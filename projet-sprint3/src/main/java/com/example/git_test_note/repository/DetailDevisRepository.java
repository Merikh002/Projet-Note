package com.example.git_test_note.repository;

import com.example.git_test_note.model.DetailDevis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetailDevisRepository extends JpaRepository<DetailDevis, Long> {
    @Modifying
    @Query("DELETE FROM DetailDevis d WHERE d.devis.id = :devis_id")
    void deleteByDevisId(@Param("devis_id") Long devisId);
}

