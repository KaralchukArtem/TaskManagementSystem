package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.dto.task.CreateTaskDTO;
import com.example.taskmanagementsystem.dto.task.UpdateTaskDTO;
import com.example.taskmanagementsystem.dto.task.ViewTaskDTO;
import com.example.taskmanagementsystem.entities.Task;
import com.example.taskmanagementsystem.entities.User;
import com.example.taskmanagementsystem.mapper.TaskMapper;
import com.example.taskmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private PriorityService priorityService;
    @Autowired
    private StatusService statusService ;

    public Task createTask(CreateTaskDTO createTaskDTO, Optional<User> user) {
        Task task = new Task();
        if (user.isPresent()){
            task = getModelFromCreateTask(createTaskDTO,user.get());
        }else {
            user.orElseThrow(()-> new RuntimeException("Пользователь отсутсвует"));
        }
        taskRepository.save(task);
        return task;
    }
    private Task getModelFromCreateTask(CreateTaskDTO createTaskDTO, User user){
        Task task = new Task();
        task.setTitle(createTaskDTO.getTitle());
        task.setDescription(createTaskDTO.getDescription());
        task.setExecutor(createTaskDTO.getExecutor());
        task.setAuthor_id(user);
        task.setStatus_id(statusService.getStatusById(createTaskDTO.getPriority_id()));
        task.setPriority_id(priorityService.getPriorityById(createTaskDTO.getPriority_id()));
        return task;
    }
    public Task updateTask(UpdateTaskDTO updateTaskDTO) {
        Task task = getModelFromUpdateTask(updateTaskDTO);
        taskRepository.save(task);
        return task;
    }
    private Task getModelFromUpdateTask(UpdateTaskDTO updateTaskDTO){
        Task task = new Task();
        task.setId(updateTaskDTO.getId());
        task.setTitle(updateTaskDTO.getTitle());
        task.setDescription(updateTaskDTO.getDescription());
        task.setExecutor(updateTaskDTO.getExecutor());
        task.setAuthor_id(updateTaskDTO.getAuthor_id());
        task.setStatus_id(statusService.getStatusById(updateTaskDTO.getPriority_id()));
        task.setPriority_id(priorityService.getPriorityById(updateTaskDTO.getPriority_id()));
        return task;
    }

    public Task getTask(int id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Статут с таким id не найден"));
        return task;
    }
    public ViewTaskDTO viewTask(int id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Статут с таким id не найден"));
        return taskMapper.ViewTaskEntityToDTO(task);
    }

    public List<ViewTaskDTO> viewTaskByAuthor(String email) {
        User user1 = userService.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Автор с таким id не найден"));
        System.out.println(user1.toString());
        List<Task> tasksEntity = taskRepository.findByAuthor_id(user1.getId());
        return taskMapper.ViewTaskEntityToDTOList(tasksEntity);
    }

    public List<ViewTaskDTO> viewAllTask() {
        List<Task> task = taskRepository.findAll();
        return taskMapper.ViewTaskEntityToDTOList(task);
    }

    public boolean deleteTask(int id) {
        if (taskRepository.findById(id).isPresent()) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
