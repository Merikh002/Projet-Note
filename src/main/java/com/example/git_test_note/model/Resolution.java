package com.example.git_test_note.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resolution {
    @Id @GeneratedValue
    private Long id;
    
    private Double min;

    private Double max;
    
    private Double avg;
}
