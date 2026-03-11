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
public class Deliberation {
    @Id @GeneratedValue
    private Long id;
    

    @ManyToOne
    private Etudiant etudiant;

    @ManyToOne
    private Matiere matiere;

    @ManyToOne
    private Resolution resolution;

    private LocalDateTime dateDeliberation;


}