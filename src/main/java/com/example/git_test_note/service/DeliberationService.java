package com.example.git_test_note.service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.git_test_note.model.Matiere;
import com.example.git_test_note.model.Note;
import com.example.git_test_note.model.NoteFinal;
import com.example.git_test_note.model.Parametre;
import com.example.git_test_note.repository.EtudiantRepository;
import com.example.git_test_note.repository.MatiereRepository;
import com.example.git_test_note.repository.NoteFinalRepository;
import com.example.git_test_note.repository.NoteRepository;
import com.example.git_test_note.repository.ParametreRepository;

/**
 * Service in charge of running the deliberation algorithm described in the
 * existing JDBC code.  This implementation is repository‑based and works with
 * the project entities (Note, Parametre, ...).  The result is persisted in
 * the NoteFinal table.
 */
@Service
public class DeliberationService {

    private final NoteRepository noteRepository;
    private final ParametreRepository parametreRepository;
    private final NoteFinalRepository noteFinalRepository;
    private final EtudiantRepository etudiantRepository;
    private final MatiereRepository matiereRepository;

    public DeliberationService(NoteRepository noteRepository,
                               ParametreRepository parametreRepository,
                               NoteFinalRepository noteFinalRepository,
                               EtudiantRepository etudiantRepository,
                               MatiereRepository matiereRepository) {
        this.noteRepository = noteRepository;
        this.parametreRepository = parametreRepository;
        this.noteFinalRepository = noteFinalRepository;
        this.etudiantRepository = etudiantRepository;
        this.matiereRepository = matiereRepository;
    }

    /**
     * Runs the deliberation algorithm for a single student/subject pair and
     * persists the chosen final value (create or update).
     *
     * @param etudiantId id of the student
     * @param matiereId  id of the subject
     * @return the final value chosen by the algorithm or {@code null} if no notes
     *         exist for the combination.
     */
    @Transactional
    public Double delibererPourEtudiantMatiere(Long etudiantId, Long matiereId) {
        List<Note> notes = noteRepository.findByEtudiantIdAndMatiereId(etudiantId, matiereId);
        if (notes.isEmpty()) {
            return null;
        }

        // compute statistics
        DoubleSummaryStatistics stats = notes.stream()
                .mapToDouble(Note::getValeur)
                .summaryStatistics();

        double min = stats.getMin();
        double max = stats.getMax();
        double avg = stats.getAverage();

        printNoteValues(notes, etudiantId, matiereId);

        long correcteursCount = noteRepository.countDistinctProfesseurs(etudiantId, matiereId);
        if (correcteursCount == 2) {
            Double valeur = avg;
            upsertNoteFinale(etudiantId, matiereId, valeur);
            return valeur;
        }

        double difference = max - min;

        // look for a matching parameter rule
        String selectedSolution = null;
        Double selectedSeuil = null;
        String selectedMethode = null;

        List<Parametre> params = parametreRepository.findByMatiereId(matiereId);
        for (Parametre p : params) {
            if (p.getComparateur() == null || p.getResolution() == null || p.getSeuil() == null) {
                continue;
            }
            String methode = p.getComparateur().getStringValeur();
            Double seuil = p.getSeuil();
            String solution = p.getResolution().getStringValeur();

            boolean matches = false;
            switch (methode.trim()) {
                case "<":
                    matches = difference < seuil;
                    break;
                case ">":
                    matches = difference > seuil;
                    break;
                default:
                    // unknown comparator, ignore
            }

            if (matches) {
                selectedSolution = solution;
                selectedMethode = methode;
                selectedSeuil = seuil;
                break;
            }
        }

        Double finalValue = chooseFinalValue(min, max, avg, selectedSolution);
        if (finalValue != null) {
            upsertNoteFinale(etudiantId, matiereId, finalValue);
        }
        return finalValue;
    }

    private Double chooseFinalValue(double min, double max, double avg, String solution) {
        if (solution == null) {
            // default to average
            return avg;
        }
        switch (solution.trim()) {
            case "Min":
                return min;
            case "Max":
                return max;
            case "Moyenne":
                return avg;
            default:
                return avg;
        }
    }

    private void printNoteValues(List<Note> notes, Long etudiantId, Long matiereId) {
        String values = notes.stream()
                .map(Note::getValeur)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Notes utilisées pour la moyenne (etudiant=" + etudiantId +
                ", matiere=" + matiereId + "): [" + values + "]");
    }

    private void upsertNoteFinale(Long etudiantId, Long matiereId, Double valeur) {
        Optional<NoteFinal> existing = noteFinalRepository.findByEtudiantIdAndMatiereId(etudiantId, matiereId);
        NoteFinal noteFinal;
        if (existing.isPresent()) {
            noteFinal = existing.get();
            noteFinal.setValeur(valeur);
        } else {
            noteFinal = new NoteFinal();
            noteFinal.setEtudiant(etudiantRepository.findById(etudiantId).orElse(null));
            noteFinal.setMatiere(matiereRepository.findById(matiereId).orElse(null));
            noteFinal.setValeur(valeur);
        }
        noteFinalRepository.save(noteFinal);
    }
}