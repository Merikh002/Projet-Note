package com.example.git_test_note.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.git_test_note.model.Etudiant;
import com.example.git_test_note.model.Matiere;
import com.example.git_test_note.model.Note;
import com.example.git_test_note.model.NoteFinal;
import com.example.git_test_note.model.Parametre;
import com.example.git_test_note.model.Resolution;
import com.example.git_test_note.repository.EtudiantRepository;
import com.example.git_test_note.repository.MatiereRepository;
import com.example.git_test_note.repository.NoteFinalRepository;
import com.example.git_test_note.repository.NoteRepository;
import com.example.git_test_note.repository.ParametreRepository;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteFinalRepository noteFinalRepository;
    private final ParametreRepository parametreRepository;
    private final EtudiantRepository etudiantRepository;
    private final MatiereRepository matiereRepository;

    public NoteService(NoteRepository noteRepository,
                       NoteFinalRepository noteFinalRepository,
                       ParametreRepository parametreRepository,
                       EtudiantRepository etudiantRepository,
                       MatiereRepository matiereRepository) {
        this.noteRepository = noteRepository;
        this.noteFinalRepository = noteFinalRepository;
        this.parametreRepository = parametreRepository;
        this.etudiantRepository = etudiantRepository;
        this.matiereRepository = matiereRepository;
    }

    /**
     * Count how many distinct professors graded a given student for a given subject.
     */
    public long countCorrecteurs(Long etudiantId, Long matiereId) {
        return noteRepository.countDistinctCorrecteurs(etudiantId, matiereId);
    }

    /**
     * Calculate the difference between the maximum and minimum note for a student
     * in a specific subject.
     */
    public BigDecimal calculerDifferenceNote(Long etudiantId, Long matiereId) {
        List<Note> notes = noteRepository.findByEtudiantIdAndMatiereId(etudiantId, matiereId);
        if (notes.isEmpty()) {
            return BigDecimal.ZERO;
        }
        double min = notes.stream().mapToDouble(Note::getValeur).min().orElse(0);
        double max = notes.stream().mapToDouble(Note::getValeur).max().orElse(0);
        return BigDecimal.valueOf(max - min);
    }

    /**
     * Compute and persist the final note for a student and a subject.
     *
     * Logic:
     *  1) Récupère toutes les notes des correcteurs pour le candidat/matière
     *  2) Si < 2 notes -> moyenne (ou la note unique)
     *  3) Sinon -> calcule le SAD (sommes des absolues des différences)
     *  4) Choisit la résolution en fonction des paramètres (table parametre)
     *  5) Applique la résolution pour obtenir la note finale
     */
    public double calculerEtEnregistrerNoteFinale(Long etudiantId, Long matiereId) {
        List<Double> notesProfs = getNotesValues(etudiantId, matiereId);
        if (notesProfs.isEmpty()) {
            return 0;
        }

        double noteFinale;
        if (notesProfs.size() <= 1) {
            noteFinale = moyenne(notesProfs);
        } else {
            double sad = calculerSAD(notesProfs);
            Resolution resolution = choisirResolution(matiereId, sad);
            noteFinale = appliquerResolution(notesProfs, resolution);
        }

        Etudiant etudiant = etudiantRepository.getReferenceById(etudiantId);
        Matiere matiere = matiereRepository.getReferenceById(matiereId);

        NoteFinal noteFinal = noteFinalRepository.findByEtudiantIdAndMatiereId(etudiantId, matiereId)
                .orElse(new NoteFinal());
        noteFinal.setEtudiant(etudiant);
        noteFinal.setMatiere(matiere);
        noteFinal.setValeur(noteFinale);

        noteFinalRepository.save(noteFinal);
        return noteFinale;
    }

    private List<Double> getNotesValues(Long etudiantId, Long matiereId) {
        List<Note> notes = noteRepository.findByEtudiantIdAndMatiereId(etudiantId, matiereId);
        List<Double> values = new ArrayList<>();
        for (Note note : notes) {
            if (note != null && note.getValeur() != null) {
                values.add(note.getValeur());
            }
        }
        return values;
    }

    public double calculerSAD(List<Double> notes) {
        double sad = 0;
        for (int i = 0; i < notes.size(); i++) {
            for (int j = i + 1; j < notes.size(); j++) {
                sad += Math.abs(notes.get(i) - notes.get(j));
            }
        }
        return sad;
    }

    public Resolution choisirResolution(Long matiereId, double sad) {
        List<Parametre> params = parametreRepository.findByMatiereId(matiereId);
        if (params.isEmpty()) {
            return defaultResolution();
        }

        List<Parametre> matching = new ArrayList<>();
        for (Parametre p : params) {
            if (p == null || p.getOperation() == null || p.getSeuil() == null) {
                continue;
            }
            if (matches(p.getOperation().getSigne(), sad, p.getSeuil())) {
                matching.add(p);
            }
        }

        Comparator<Parametre> byProximityThenSeuil = Comparator
                .comparingDouble((Parametre p) -> Math.abs(sad - p.getSeuil()))
                .thenComparingDouble(Parametre::getSeuil);

        if (!matching.isEmpty()) {
            return matching.stream().min(byProximityThenSeuil).get().getResolution();
        }

        // if no rule matches, fallback to nearest seuil (tie => lower seuil)
        return params.stream()
                .filter(p -> p != null && p.getSeuil() != null)
                .min(byProximityThenSeuil)
                .map(Parametre::getResolution)
                .orElse(defaultResolution());
    }

    private boolean matches(String signe, double value, double seuil) {
        if (signe == null) {
            return false;
        }
        switch (signe.trim()) {
            case "<":
                return value < seuil;
            case "<=":
                return value <= seuil;
            case ">":
                return value > seuil;
            case ">=":
                return value >= seuil;
            case "=":
            case "==":
                return value == seuil;
            default:
                return false;
        }
    }

    private Resolution defaultResolution() {
        Resolution moyenne = new Resolution();
        moyenne.setLibelle("Moyen");
        return moyenne;
    }

    public double appliquerResolution(List<Double> notes, Resolution resolution) {
        if (notes == null || notes.isEmpty()) {
            return 0;
        }

        String libelle = (resolution != null && resolution.getLibelle() != null)
                ? resolution.getLibelle().trim().toLowerCase()
                : "Moyen";

        switch (libelle) {
            case "min":
            case "petit":
            case "minimum":
                return notes.stream().mapToDouble(Double::doubleValue).min().orElse(0);
            case "max":
            case "grand":
            case "maximum":
                return notes.stream().mapToDouble(Double::doubleValue).max().orElse(0);
            case "moyen":
            case "avg":
            case "average":
                return moyenne(notes);
            default:
                return moyenne(notes);
        }
    }

    private double moyenne(List<Double> notes) {
        return notes.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    /**
     * List all final notes stored in the repository.
     */
    public List<NoteFinal> listerNotesFinales() {
        return new ArrayList<>(noteFinalRepository.findAll());
    }
}

