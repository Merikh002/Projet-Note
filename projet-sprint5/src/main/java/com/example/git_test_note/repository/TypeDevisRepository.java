package com.example.git_test_note.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.git_test_note.model.TypeDevis;

public interface TypeDevisRepository extends JpaRepository<TypeDevis, Long> {

}

