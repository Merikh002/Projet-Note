package com.example.git_test_note.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class NoteFinalId implements Serializable {

    private Long etudiant;
    private Long matiere;
    
}
