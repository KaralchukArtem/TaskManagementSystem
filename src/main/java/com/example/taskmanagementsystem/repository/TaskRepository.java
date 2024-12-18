package com.example.taskmanagementsystem.repository;

import com.example.taskmanagementsystem.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("SELECT t FROM Task AS t WHERE t.author_id.id = :id")
    List<Task> findByAuthor_id(@Param("id") int id);
}