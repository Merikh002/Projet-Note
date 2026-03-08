package com.example.git_test_note.model;

import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id @GeneratedValue
    private Long id;
    

    @ManyToOne
    private Etudiant etudiant;

    @ManyToOne
    private Professeur professeur;

    @ManyToOne
    private Matiere matiere;

    private Double value;

    private LocalDateTime dateHeure;
}