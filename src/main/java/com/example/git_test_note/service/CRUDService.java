package com.example.git_test_note.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.git_test_note.model.Etudiant;
import com.example.git_test_note.model.Correcteur;
import com.example.git_test_note.repository.EtudiantRepository;
import com.example.git_test_note.repository.CorrecteurRepository;
import com.example.git_test_note.model.Matiere;
import com.example.git_test_note.repository.MatiereRepository;
import com.example.git_test_note.model.Resolution;
import com.example.git_test_note.repository.ResolutionRepository;
import com.example.git_test_note.model.Operation;
import com.example.git_test_note.repository.OperationRepository;
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

    //Correcteur
    private final CorrecteurRepository correcteurRepository;

    public void createCorrecteur(Correcteur correcteur) {
        correcteurRepository.save(correcteur);
    }

    public List<Correcteur> getAllCorrecteurs() {
        return correcteurRepository.findAll();
    }

    public Correcteur findByIdCorrecteur(Long id) {
        return correcteurRepository.findById(id).orElse(null);
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
    private final OperationRepository operationRepository;

    public void createComparateur(Operation comparateur) {
        operationRepository.save(comparateur);
    }

    public List<Operation> getAllComparateurs() {
        return operationRepository.findAll();
    }

    public Operation findByIdComparateur(Long id) {
        return operationRepository.findById(id).orElse(null);
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
                       CorrecteurRepository correcteurRepository,
                       MatiereRepository matiereRepository,
                       ResolutionRepository resolutionRepository,
                       OperationRepository operationRepository,
                       NoteRepository noteRepository,
                       NoteFinalRepository noteFinalRepository,
                       ParametreRepository parametreRepository) {
        this.etudiantRepository = etudiantRepository;
        this.correcteurRepository = correcteurRepository;
        this.matiereRepository = matiereRepository;
        this.resolutionRepository = resolutionRepository;
        this.operationRepository = operationRepository;
        this.noteRepository = noteRepository;
        this.noteFinalRepository = noteFinalRepository;
        this.parametreRepository = parametreRepository;
    }
}
