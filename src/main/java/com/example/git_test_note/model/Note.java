package com.example.git_test_note.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(NoteId.class)
public class Note {
    @Id
    @ManyToOne
    private Etudiant etudiant;

    @Id
    @ManyToOne
    @JoinColumn(name = "correcteur_id")
    private Correcteur correcteur;

    @Id
    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    private Double valeur;
}