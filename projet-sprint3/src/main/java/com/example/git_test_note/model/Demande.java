package com.example.git_test_note.model;

import java.util.Date;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Demande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateDemande;

    private String description;

    private String lieu;
    
    @ManyToOne
    @JoinColumn(name ="client_id")
    private Client client;

    public Demande() {}
    

   

}