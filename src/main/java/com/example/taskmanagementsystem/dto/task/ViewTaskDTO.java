package com.example.taskmanagementsystem.dto.task;

import com.example.taskmanagementsystem.entities.Priority;
import com.example.taskmanagementsystem.entities.Status;
import com.example.taskmanagementsystem.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTaskDTO {
    private int id;
    private String title;
    private String description;
    private String executor;
    private User author_id;
    private Status status_id;
    private Priority priority_id;
}
