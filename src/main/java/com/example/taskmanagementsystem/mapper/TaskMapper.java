package com.example.taskmanagementsystem.mapper;

import com.example.taskmanagementsystem.dto.task.CreateTaskDTO;
import com.example.taskmanagementsystem.dto.task.UpdateTaskDTO;
import com.example.taskmanagementsystem.dto.task.ViewTaskDTO;
import com.example.taskmanagementsystem.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@Component
public interface TaskMapper {
//    Task CreateTaskDTOtoEntity(CreateTaskDTO taskDTO);

//    Task UpdateTaskEntityToDTO(UpdateTaskDTO taskDTO);

    ViewTaskDTO ViewTaskEntityToDTO(Task task);

    List<ViewTaskDTO> ViewTaskEntityToDTOList(List<Task> tasks);
}
