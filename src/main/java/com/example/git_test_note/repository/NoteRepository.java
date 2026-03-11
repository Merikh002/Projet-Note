package com.example.git_test_note.repository;

import com.example.git_test_note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // custom finder for deliberation logic
    List<Note> findByEtudiantIdAndMatiereId(Long etudiantId, Long matiereId);

    @Query("SELECT COUNT(DISTINCT n.professeur.id) FROM Note n " +
           "WHERE n.etudiant.id = :etudiantId AND n.matiere.id = :matiereId")
    long countDistinctProfesseurs(@Param("etudiantId") Long etudiantId,
                                  @Param("matiereId") Long matiereId);
}

