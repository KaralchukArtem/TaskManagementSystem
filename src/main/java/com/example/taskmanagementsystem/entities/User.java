package com.example.taskmanagementsystem.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
@ToString
@Schema(description = "Пользователь")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Login is required.")
    @Size(min = 3, max = 20, message = "Login must be between 3 and 20 characters.")
    @Column(name = "login")
    private String login;
    @NotBlank(message = "Login is required.")
    @Size(min = 3, max = 200, message = "Login must be between 3 and 20 characters.")
    @Column(name = "password")
    private String password;
    @NotBlank(message = "Login is required.")
    @Size(min = 3, max = 20, message = "Login must be between 3 and 20 characters.")
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role_id;
}
