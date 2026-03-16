package com.example.git_test_note.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.git_test_note.model.Etudiant;
import com.example.git_test_note.model.Correcteur;
import com.example.git_test_note.model.Matiere;
import com.example.git_test_note.model.Resolution;
import com.example.git_test_note.model.Operation;
import com.example.git_test_note.model.Note;
import com.example.git_test_note.model.NoteFinal;
import com.example.git_test_note.model.Parametre;
import com.example.git_test_note.service.CRUDService;

@RestController
@RequestMapping("/api")
public class CRUDController {

    private final CRUDService crudService;
    private final com.example.git_test_note.service.NoteService noteService;

    public CRUDController(CRUDService crudService, com.example.git_test_note.service.NoteService noteService) {
        this.crudService = crudService;
        this.noteService = noteService;
    }

    // ====================
    // ETUDIANTS
    // ====================

    @PostMapping("/etudiants")
    public void createEtudiant(@RequestBody Etudiant etudiant) {
        crudService.createEtudiant(etudiant);
    }

    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants() {
        return crudService.getAllEtudiants();
    }

    @GetMapping("/etudiants/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return crudService.findByIdEtudiant(id);
    }

    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        boolean deleted = crudService.deleteEtudiant(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // CORRECTEURS
    // ====================

    @PostMapping("/correcteurs")
    public void createCorrecteur(@RequestBody Correcteur correcteur) {
        crudService.createCorrecteur(correcteur);
    }

    @GetMapping("/correcteurs")
    public List<Correcteur> getAllCorrecteurs() {
        return crudService.getAllCorrecteurs();
    }

    @GetMapping("/correcteurs/{id}")
    public Correcteur getCorrecteurById(@PathVariable Long id) {
        return crudService.findByIdCorrecteur(id);
    }

    @DeleteMapping("/correcteurs/{id}")
    public ResponseEntity<Void> deleteCorrecteur(@PathVariable Long id) {
        boolean deleted = crudService.deleteCorrecteur(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // MATIERES
    // ====================

    @PostMapping("/matieres")
    public void createMatiere(@RequestBody Matiere matiere) {
        crudService.createMatiere(matiere);
    }

    @GetMapping("/matieres")
    public List<Matiere> getAllMatieres() {
        return crudService.getAllMatieres();
    }

    @GetMapping("/matieres/{id}")
    public Matiere getMatiereById(@PathVariable Long id) {
        return crudService.findByIdMatiere(id);
    }

    @DeleteMapping("/matieres/{id}")
    public ResponseEntity<Void> deleteMatiere(@PathVariable Long id) {
        boolean deleted = crudService.deleteMatiere(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // RESOLUTIONS
    // ====================

    @PostMapping("/resolutions")
    public void createResolution(@RequestBody Resolution resolution) {
        crudService.createResolution(resolution);
    }

    @GetMapping("/resolutions")
    public List<Resolution> getAllResolutions() {
        return crudService.getAllResolutions();
    }

    @GetMapping("/resolutions/{id}")
    public Resolution getResolutionById(@PathVariable Long id) {
        return crudService.findByIdResolution(id);
    }

    @DeleteMapping("/resolutions/{id}")
    public ResponseEntity<Void> deleteResolution(@PathVariable Long id) {
        boolean deleted = crudService.deleteResolution(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // OPERATIONS
    // ====================

    @PostMapping("/operations")
    public void createOperation(@RequestBody Operation operation) {
        crudService.createOperation(operation);
    }

    @GetMapping("/operations")
    public List<Operation> getAllOperations() {
        return crudService.getAllOperations();
    }

    @GetMapping("/operations/{id}")
    public Operation getOperationById(@PathVariable Long id) {
        return crudService.findByIdOperation(id);
    }

    @DeleteMapping("/operations/{id}")
    public ResponseEntity<Void> deleteOperation(@PathVariable Long id) {
        boolean deleted = crudService.deleteOperation(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // NOTES
    // ====================

    @PostMapping("/notes")
    public void createNote(@RequestBody Note note) {
        crudService.createNote(note);
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return crudService.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return crudService.findByIdNote(id);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        boolean deleted = crudService.deleteNote(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ====================
    // NOTES FINALES
    // ====================

    @PostMapping("/notes-finales")
    public void createNoteFinal(@RequestBody NoteFinal noteFinal) {
        crudService.createNoteFinal(noteFinal);
    }

    @GetMapping("/notes-finales")
    public List<NoteFinal> getAllNotesFinales() {
        return crudService.getAllNotesFinal();
    }

    @GetMapping("/notes-finales/{id}")
    public NoteFinal getNoteFinalById(@PathVariable Long id) {
        return crudService.findByIdNoteFinal(id);
    }

    // ====================
    // PARAMETRES
    // ====================

    @PostMapping("/parametres")
    public void createParametre(@RequestBody Parametre parametre) {
        crudService.createParametre(parametre);
    }

    @GetMapping("/parametres")
    public List<Parametre> getAllParametres() {
        return crudService.getAllParametres();
    }

    @GetMapping("/parametres/{id}")
    public Parametre getParametreById(@PathVariable Long id) {
        return crudService.findByIdParametre(id);
    }

    @DeleteMapping("/parametres/{id}")
    public ResponseEntity<Void> deleteParametre(@PathVariable Long id) {
        boolean deleted = crudService.deleteParametre(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}