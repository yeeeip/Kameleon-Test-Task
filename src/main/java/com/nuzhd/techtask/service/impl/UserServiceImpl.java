package com.nuzhd.techtask.service.impl;

import com.nuzhd.techtask.model.User;
import com.nuzhd.techtask.repository.UserRepository;
import com.nuzhd.techtask.service.UserService;
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
