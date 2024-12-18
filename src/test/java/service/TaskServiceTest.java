package service;

import com.example.taskmanagementsystem.TaskManagementSystemApplication;
import com.example.taskmanagementsystem.dto.task.CreateTaskDTO;
import com.example.taskmanagementsystem.entities.Role;
import com.example.taskmanagementsystem.entities.Task;
import com.example.taskmanagementsystem.entities.User;
import com.example.taskmanagementsystem.repository.TaskRepository;
import com.example.taskmanagementsystem.service.PriorityService;
import com.example.taskmanagementsystem.service.StatusService;
import com.example.taskmanagementsystem.service.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = TaskManagementSystemApplication.class)
public class TaskServiceTest {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private PriorityService priorityService;

    @DisplayName("Test get by id")
    @Test
    public void getTaskById() {
        Task task = taskRepository.findById(10).get();
        assertThat(task.getId()).isEqualTo(10);
    }

    @DisplayName("Test create Task")
    @Test
    public void createTask() {
        Role role = new Role();
        role.setId(1);
        role.setName("USER");

        User user = new User();
        user.setId(1);
        user.setEmail("Tema@gmail.com");
        user.setLogin("BlackZarT");
        user.setPassword("password");
        user.setRole_id(role);

        CreateTaskDTO createTaskDTO = new CreateTaskDTO();
        createTaskDTO.setTitle("Title Create");
        createTaskDTO.setDescription("Description create");
        createTaskDTO.setExecutor("tema@gmail.com");
        createTaskDTO.setAuthor_id(user);
        createTaskDTO.setStatus_id(1);
        createTaskDTO.setPriority_id(1);

        Task task = new Task();
        task.setTitle(createTaskDTO.getTitle());
        task.setDescription(createTaskDTO.getDescription());
        task.setExecutor(createTaskDTO.getExecutor());
        task.setAuthor_id(user);
        task.setStatus_id(statusService.getStatusById(createTaskDTO.getPriority_id()));
        task.setPriority_id(priorityService.getPriorityById(createTaskDTO.getPriority_id()));

        Task newTask = taskService.createTask(createTaskDTO, Optional.of(user));
        assertThat(newTask).isNotNull();

        assertThat(newTask.getTitle()).isEqualTo(task.getTitle());
        assertThat(newTask.getDescription()).isEqualTo(task.getDescription());
        assertThat(newTask.getExecutor()).isEqualTo(task.getExecutor());
        assertThat(newTask.getAuthor_id()).isEqualTo(task.getAuthor_id());
        assertThat(newTask.getStatus_id().getType()).isEqualTo(task.getStatus_id().getType());
        assertThat(newTask.getPriority_id().getType()).isEqualTo(task.getPriority_id().getType());
    }
}
