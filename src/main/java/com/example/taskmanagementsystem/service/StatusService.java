package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.entities.Status;
import com.example.taskmanagementsystem.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getStatus() {
        return statusRepository.findAll();
    }
    public Status getStatusById(int id) {
        return statusRepository.findById(id).orElseThrow(()->new RuntimeException(""));
    }
}
