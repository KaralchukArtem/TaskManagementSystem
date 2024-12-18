package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.entities.Priority;
import com.example.taskmanagementsystem.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {
    @Autowired
    private PriorityRepository priorityRepository;

    public List<Priority> getPriority() {
        return priorityRepository.findAll();
    }
    public Priority getPriorityById(int id) {
        return priorityRepository.findById(id).orElseThrow(()-> new RuntimeException("Приоритета не найдено"));
    }
}
