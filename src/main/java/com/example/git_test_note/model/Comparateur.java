package com.example.git_test_note.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comparateur {
    @Id @GeneratedValue
    private Long id;
    
    private String symbol; // "<" ou ">"
    private String ref;    // "under" ou "above"
}