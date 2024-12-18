package com.example.taskmanagementsystem.entities;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "task")
@Schema(description = "Задача")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Title is required.")
    @Size(min = 3, max = 20, message = "Title must be between 3 and 20 characters.")
    @Column(name = "title")
    private String title;
    @NotBlank(message = "Description is required.")
    @Size(min = 3, max = 200, message = "Description must be between 3 and 20 characters.")
    @Column(name = "description")
    private String description;
    @NotBlank(message = "Executor is required.")
    @Size(min = 3, max = 20, message = "Executor must be between 3 and 20 characters.")
    @Column(name = "executor")
    private String executor;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author_id;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status_id;
    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority_id;
    @Hidden
    @Schema(description = "Дата регистрации", example = "2023-01-01", accessMode = Schema.AccessMode.READ_ONLY)
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}
