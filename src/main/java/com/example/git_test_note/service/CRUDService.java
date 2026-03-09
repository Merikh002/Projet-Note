package com.example.git_test_note.service;

import java.util.List;

import com.example.git_test_note.model.Etudiant;
import com.example.git_test_note.model.Professeur;
import com.example.git_test_note.repository.EtudiantRepository;
import com.example.git_test_note.repository.ProfesseurRepository;


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


    public CRUDService(EtudiantRepository etudiantRepository,
                       ProfesseurRepository professeurRepository) {
        this.etudiantRepository = etudiantRepository;
        this.professeurRepository = professeurRepository;
    }
}
