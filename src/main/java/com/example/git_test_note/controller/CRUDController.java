package com.example.git_test_note.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.git_test_note.model.Etudiant;
import com.example.git_test_note.model.Professeur;
import com.example.git_test_note.service.CRUDService;

@RestController
@RequestMapping("/api")
public class CRUDController {

    private final CRUDService crudService;

    public CRUDController(CRUDService crudService) {
        this.crudService = crudService;
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
    // PROFESSEURS
    // ====================

    @PostMapping("/professeurs")
    public void createProfesseur(@RequestBody Professeur professeur) {
        crudService.createProfesseur(professeur);
    }

    @GetMapping("/professeurs")
    public List<Professeur> getAllProfesseurs() {
        return crudService.getAllProfesseurs();
    }

    @GetMapping("/professeurs/{id}")
    public Professeur getProfesseurById(@PathVariable Long id) {
        return crudService.findByIdProfesseur(id);
    }
}