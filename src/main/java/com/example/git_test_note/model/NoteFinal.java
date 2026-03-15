package com.example.git_test_note.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(NoteFinalId.class)
public class NoteFinal {
    @Id
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @Id
    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    private Double valeur;

}