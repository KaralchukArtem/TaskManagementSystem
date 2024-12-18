package com.example.taskmanagementsystem.dto.user;

import com.example.taskmanagementsystem.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String login;
    private String email;
    private Role role_id;
}
