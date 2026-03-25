package com.example.git_test_note.repository;

import com.example.git_test_note.model.StatutDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StatutDemandeRepository extends JpaRepository<StatutDemande, Long> {
}

