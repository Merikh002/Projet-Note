package com.example.git_test_note.repository;

import com.example.git_test_note.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

