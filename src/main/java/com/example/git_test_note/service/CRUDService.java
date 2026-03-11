package com.example.git_test_note.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.git_test_note.model.Etudiant;
import com.example.git_test_note.model.Professeur;
import com.example.git_test_note.repository.EtudiantRepository;
import com.example.git_test_note.repository.ProfesseurRepository;
import com.example.git_test_note.model.Matiere;
import com.example.git_test_note.repository.MatiereRepository;
import com.example.git_test_note.model.Resolution;
import com.example.git_test_note.repository.ResolutionRepository;
import com.example.git_test_note.model.Comparateur;
import com.example.git_test_note.repository.ComparateurRepository;
import com.example.git_test_note.model.Note;
import com.example.git_test_note.repository.NoteRepository;
import com.example.git_test_note.model.NoteFinal;
import com.example.git_test_note.repository.NoteFinalRepository;
import com.example.git_test_note.model.Parametre;
import com.example.git_test_note.repository.ParametreRepository;


@Service
public class CRUDService {

   
    
    //Etudiant
    private final EtudiantRepository etudiantRepository;


    public void createEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant findByIdEtudiant(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    //Professeur
    private final ProfesseurRepository professeurRepository;

    public void createProfesseur(Professeur professeur) {
        professeurRepository.save(professeur);
    }

    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    public Professeur findByIdProfesseur(Long id) {
        return professeurRepository.findById(id).orElse(null);
    }

    //Matiere
    private final MatiereRepository matiereRepository;

    public void createMatiere(Matiere matiere) {
        matiereRepository.save(matiere);
    }

    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    public Matiere findByIdMatiere(Long id) {
        return matiereRepository.findById(id).orElse(null);
    }

    //Resolution
    private final ResolutionRepository resolutionRepository;

    public void createResolution(Resolution resolution) {
        resolutionRepository.save(resolution);
    }

    public List<Resolution> getAllResolutions() {
        return resolutionRepository.findAll();
    }

    public Resolution findByIdResolution(Long id) {
        return resolutionRepository.findById(id).orElse(null);
    }

    //Comparateur
    private final ComparateurRepository comparateurRepository;

    public void createComparateur(Comparateur comparateur) {
        comparateurRepository.save(comparateur);
    }

    public List<Comparateur> getAllComparateurs() {
        return comparateurRepository.findAll();
    }

    public Comparateur findByIdComparateur(Long id) {
        return comparateurRepository.findById(id).orElse(null);
    }

    //Note
    private final NoteRepository noteRepository;

    public void createNote(Note note) {
        noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note findByIdNote(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    //NoteFinal

    private final NoteFinalRepository noteFinalRepository;

    public void createNoteFinal(NoteFinal noteFinal) {
        noteFinalRepository.save(noteFinal);
    }

    public List<NoteFinal> getAllNotesFinal() {
        return noteFinalRepository.findAll();
    }

    public NoteFinal findByIdNoteFinal(Long id) {
        return noteFinalRepository.findById(id).orElse(null);
    }

    //parametre

    private final ParametreRepository parametreRepository;

    public void createParametre(Parametre parametre) {
        parametreRepository.save(parametre);
    }

    public List<Parametre> getAllParametres() {
        return parametreRepository.findAll();
    }

    public Parametre findByIdParametre(Long id) {
        return parametreRepository.findById(id).orElse(null);
    }



    public CRUDService(EtudiantRepository etudiantRepository,
                       ProfesseurRepository professeurRepository,
                       MatiereRepository matiereRepository,
                       ResolutionRepository resolutionRepository,
                       ComparateurRepository comparateurRepository,
                       NoteRepository noteRepository,
                       NoteFinalRepository noteFinalRepository,
                       ParametreRepository parametreRepository) {
        this.etudiantRepository = etudiantRepository;
        this.professeurRepository = professeurRepository;
        this.matiereRepository = matiereRepository;
        this.resolutionRepository = resolutionRepository;
        this.comparateurRepository = comparateurRepository;
        this.noteRepository = noteRepository;
        this.noteFinalRepository = noteFinalRepository;
        this.parametreRepository = parametreRepository;
    }
}
