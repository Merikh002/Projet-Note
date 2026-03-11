package com.example.git_test_note.repository;

import com.example.git_test_note.model.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ParametreRepository extends JpaRepository<Parametre, Long> {
    List<Parametre> findByMatiereId(Long matiereId);
}

