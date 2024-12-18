package com.example.taskmanagementsystem.dto.user;

import lombok.Data;

@Data
public class RegistrationUserDTO {
    private String login;
    private String email;
    private String password;
    private String confirmPassword;
}
