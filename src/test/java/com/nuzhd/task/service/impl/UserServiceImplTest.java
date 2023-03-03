package com.nuzhd.task.service.impl;

import com.nuzhd.task.model.User;
import com.nuzhd.task.repository.UserRepository;
import com.nuzhd.task.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void createUser_WhenGivenUser_ThenReturnSameUser() {
        User user = getTestUser();

        when(userRepository.save(user))
                .thenReturn(user);

        User result = userService.create(user);

        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    void findById_WhenGivenUUIDReturnExistingUser() {
        User user = getTestUser();

        when(userRepository.findById(UUID.fromString("e58ed763-928c-4155-bee9-fdbaaadc15f3")))
                .thenReturn(Optional.of(user));

        User result = userService.findById(UUID.fromString("e58ed763-928c-4155-bee9-fdbaaadc15f3"));

        assertNotNull(result);
        assertEquals(user, result);
    }

    private User getTestUser() {
        return User.builder()
                .id(UUID.fromString("e58ed763-928c-4155-bee9-fdbaaadc15f3"))
                .username("John")
                .email("john@gmail.com")
                .password("password")
                .createdAt(LocalDateTime.of(2023, 1, 1, 12, 30))
                .build();
    }
}