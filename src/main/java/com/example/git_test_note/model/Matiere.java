package com.example.git_test_note.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matiere {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private int coefficient;
}
