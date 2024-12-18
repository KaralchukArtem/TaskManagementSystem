package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.dto.jwt.JwtRequest;
import com.example.taskmanagementsystem.dto.user.RegistrationUserDTO;
import com.example.taskmanagementsystem.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Пользователи", description = "Взаимодействие  с пользователями")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDTO registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }
}