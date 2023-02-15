package com.nuzhd.task.controller;

import com.nuzhd.task.model.User;
import com.nuzhd.task.model.UserCreationRequest;
import com.nuzhd.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreationRequest userCreationRequest) {

        User user = User.builder()
                .username(userCreationRequest.getUsername())
                .email(userCreationRequest.getEmail())
                .password(passwordEncoder.encode(userCreationRequest.getPassword()))
                .createdAt(LocalDateTime.now())
                .build();

        User createdUser = userService.create(user);

        return ResponseEntity.ok(createdUser);
    }

}
