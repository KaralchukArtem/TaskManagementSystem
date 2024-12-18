package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.entities.Role;
import com.example.taskmanagementsystem.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
