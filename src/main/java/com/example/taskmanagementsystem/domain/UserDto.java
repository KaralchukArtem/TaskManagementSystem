package com.example.taskmanagementsystem.domain;

import com.example.taskmanagementsystem.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private int id;
    private String login;
    private String email;
    private Role role_id;
}
