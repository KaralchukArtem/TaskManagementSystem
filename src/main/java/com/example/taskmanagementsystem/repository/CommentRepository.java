package com.example.taskmanagementsystem.repository;

import com.example.taskmanagementsystem.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT c FROM Comment AS c JOIN Task t ON c.task.id = t.id WHERE c.task.id = :id")
    List<Comment> findByTaskId(@Param("id") int id);
}
