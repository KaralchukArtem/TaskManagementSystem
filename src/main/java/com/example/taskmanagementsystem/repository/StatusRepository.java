package com.example.taskmanagementsystem.repository;

import com.example.taskmanagementsystem.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
    Optional<Status> findById(Integer id);
}
