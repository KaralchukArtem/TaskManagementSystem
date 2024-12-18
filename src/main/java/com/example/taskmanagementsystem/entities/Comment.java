package com.example.taskmanagementsystem.entities;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment")
@Schema(description = "Сущность комментария")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Text is required.")
    @Size(min = 3, max = 200, message = "Text must be between 3 and 200 characters.")
    @Column(name = "text")
    private String text;
    @NotBlank(message = "Commentator is required.")
    @Size(min = 3, max = 20, message = "Commentator must be between 3 and 15 characters.")
    @Column(name = "commentator")
    private String commentator;
    @Hidden
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;
}
