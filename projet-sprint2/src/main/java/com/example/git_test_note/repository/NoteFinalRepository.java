package com.example.git_test_note.repository;

import com.example.git_test_note.model.NoteFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NoteFinalRepository extends JpaRepository<NoteFinal, Long> {
    Optional<NoteFinal> findByEtudiantIdAndMatiereId(Long etudiantId, Long matiereId);
}

