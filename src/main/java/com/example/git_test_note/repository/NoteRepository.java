package com.example.git_test_note.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.git_test_note.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // custom finder for deliberation logic
    // use explicit JPQL to avoid ambiguity with nested properties
    @Query("SELECT n FROM Note n " +
           "WHERE n.etudiant.id = :etudiantId AND n.matiere.id = :matiereId")
    List<Note> findByEtudiantIdAndMatiereId(@Param("etudiantId") Long etudiantId,
                                           @Param("matiereId") Long matiereId);

    @Query("SELECT COUNT(DISTINCT n.correcteur.id) FROM Note n " +
           "WHERE n.etudiant.id = :etudiantId AND n.matiere.id = :matiereId")
    long countDistinctCorrecteurs(@Param("etudiantId") Long etudiantId,
                                  @Param("matiereId") Long matiereId);
}

