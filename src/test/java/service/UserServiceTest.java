package service;

import com.example.taskmanagementsystem.TaskManagementSystemApplication;
import com.example.taskmanagementsystem.entities.User;
import com.example.taskmanagementsystem.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = TaskManagementSystemApplication.class)
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetUsersNotNull() {
        List<User> userList = userRepository.findAll();
        assertNotNull(userList);
    }

    @Test
    public void testFindUserByEmailNotNull() {
        User user = userRepository.findByEmail("Bob1@gmail.com").get();
        assertNotNull(user);
        assertThat(user.getEmail()).isEqualTo("Bob1@gmail.com");
    }

}
