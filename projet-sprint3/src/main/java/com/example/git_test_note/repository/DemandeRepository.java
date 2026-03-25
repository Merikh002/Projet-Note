package com.example.git_test_note.repository;

import com.example.git_test_note.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
}
