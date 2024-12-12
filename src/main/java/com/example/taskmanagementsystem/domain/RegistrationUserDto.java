package com.example.taskmanagementsystem.domain;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private String login;
    private String email;
    private String password;
    private String confirmPassword;
}
