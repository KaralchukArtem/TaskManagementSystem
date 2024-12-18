package com.example.taskmanagementsystem.repository;

import com.example.taskmanagementsystem.entities.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Integer> {
    Optional<Priority> findById(Integer id);
}
