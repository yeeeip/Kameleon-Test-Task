package com.nuzhd.task.service.impl;

import com.nuzhd.task.model.User;
import com.nuzhd.task.repository.UserRepository;
import com.nuzhd.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(UUID userId) {
        return userRepository.findById(userId)
                .orElse(null);
    }
}
