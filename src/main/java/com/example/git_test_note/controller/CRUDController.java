package com.example.git_test_note.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.git_test_note.model.Etudiant;
import com.example.git_test_note.model.Correcteur;
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

    // ====================
    // NOTES FINALES (calcul / consultation)
    // ====================

    /**
     * Force le calcul de toutes les notes finales en parcourant chaque couple
     * étudiant/matière. Le service de délibération s'occupera de sauvegarder
     * les valeurs.
     */
    // @GetMapping("/notes-finales/compute")
    // public String computeAllNotesFinales() {
    //     var etudiants = crudService.getAllEtudiants();
    //     var matieres = crudService.getAllMatieres();
    //     System.out.println("computeAllNotesFinales called: " + etudiants.size() + " étudiants, "
    //             + matieres.size() + " matières");
    //     int count = 0;
    //     for (var e : etudiants) {
    //         for (var m : matieres) {
    //             System.out.println("  computing pour etudiant=" + e.getId() + " matiere=" + m.getId());
    //             noteService.getNoteFinale(e.getId(), m.getId());
    //             count++;
    //         }
    //     }
    //     return "computed " + count + " couples";
    // }

    /**
     * Retourne la liste des notes finales présentes en base.
     */
    @GetMapping("/notes-finales")
    public List<com.example.git_test_note.model.NoteFinal> getAllNotesFinales() {
        return crudService.getAllNotesFinal();
    }
}