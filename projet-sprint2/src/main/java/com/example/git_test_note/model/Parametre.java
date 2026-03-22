package com.example.git_test_note.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parametre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Matiere matiere;
 
    @ManyToOne
    private Operation operation;

    @ManyToOne
    private Resolution resolution;

    private Double seuil; 
}