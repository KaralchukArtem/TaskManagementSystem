package com.example.taskmanagementsystem.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "priority")
@Schema(description = "Приоритет")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Type is required.")
    @Size(min = 3, max = 20, message = "Type must be between 3 and 20 characters.")
    @Column(name = "type")
    private String type;
}
