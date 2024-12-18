package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.dto.comment.ViewCommentDTO;
import com.example.taskmanagementsystem.dto.task.CreateTaskDTO;
import com.example.taskmanagementsystem.dto.task.UpdateTaskDTO;
import com.example.taskmanagementsystem.dto.task.ViewTaskDTO;
import com.example.taskmanagementsystem.dto.user.UserDTO;
import com.example.taskmanagementsystem.entities.Priority;
import com.example.taskmanagementsystem.entities.Status;
import com.example.taskmanagementsystem.entities.Task;
import com.example.taskmanagementsystem.entities.User;
import com.example.taskmanagementsystem.service.PriorityService;
import com.example.taskmanagementsystem.service.StatusService;
import com.example.taskmanagementsystem.service.TaskService;
import com.example.taskmanagementsystem.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
@SecurityRequirement(name = "JWT")
@RequiredArgsConstructor
@Tag(name = "Задачи", description = "Управление задачами")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private PriorityService priorityService;


    @Operation(summary = "Получение статусов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Status.class))
            })
    })
    @GetMapping("/status")
    public ResponseEntity<?> getStatus() {
        List<Status> status = statusService.getStatus();
        return ResponseEntity.ok(status);
    }
    @Operation(summary = "Получение приоритетов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Priority.class))
            })
    })
    @GetMapping("/priority")
    public ResponseEntity<?> getPriority() {
        List<Priority> priority = priorityService.getPriority();
        return ResponseEntity.ok(priority);
    }
    @Operation(summary = "Получение авторов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = UserDTO.class))
            })
    })
    @GetMapping("/author")
    public ResponseEntity<?> getAllUser() {
        List<UserDTO> userDTOList = userService.getAllUsers();
        return ResponseEntity.ok(userDTOList);
    }
    @Operation(summary = "Обновление задач")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Task.class))
            })
    })
    @PostMapping("/update")
    public ResponseEntity<?> updateTask(@RequestBody UpdateTaskDTO updateTaskDTO) {
        Task task = taskService.updateTask(updateTaskDTO);
        return ResponseEntity.ok(task);
    }
    @Operation(summary = "Создание задачи")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = ViewTaskDTO.class))
            })
    })
    @PostMapping("/create")
    public ResponseEntity<?> createNewTask(@RequestBody CreateTaskDTO createTaskDTO, Principal principal) {
        Optional<User> user = userService.findByEmail(principal.getName());
        Task task = taskService.createTask(createTaskDTO, user);
        return ResponseEntity.ok(new ViewTaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getExecutor(),
                task.getAuthor_id(),
                task.getStatus_id(),
                task.getPriority_id()));
    }
    @Operation(summary = "Получение задачи по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = ViewTaskDTO.class))
            })
    })
    @GetMapping("/view")
    public ResponseEntity<?> viewTaskById(@RequestParam(value = "id", required = false) Integer id) {
        ViewTaskDTO task = taskService.viewTask(id);
        return ResponseEntity.ok(task);
    }
    @Operation(summary = "Получение задач по авторам")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = ViewTaskDTO.class))
            })
    })
    @GetMapping("/viewByAuthor")
    public ResponseEntity<?> viewTaskByAuthor(@RequestParam(value = "email", required = false) String email) {
        List<ViewTaskDTO> task = taskService.viewTaskByAuthor(email);
        return ResponseEntity.ok(task);
    }
    @Operation(summary = "Получение задач")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = ViewTaskDTO.class))
            })
    })
    @GetMapping("/viewAll")
    public ResponseEntity<?> viewTasks() {
        List<ViewTaskDTO> task = taskService.viewAllTask();
        return ResponseEntity.ok(task);
    }
    @Operation(summary = "Удаление задачи по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "boolean request")
    })
    @GetMapping("/delete")
    public ResponseEntity<?> deleteTask(@RequestParam(value = "id", required = false) Integer id) {
        Boolean task = taskService.deleteTask(id);
        return ResponseEntity.ok(task);
    }

}