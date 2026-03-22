package com.example.git_test_note.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nom;
    
    public Etudiant(){}

    public Etudiant(String nom) {
        this.nom = nom;
    }

   

}