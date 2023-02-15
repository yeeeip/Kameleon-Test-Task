package com.nuzhd.task.service;

import com.nuzhd.task.model.User;

import java.util.UUID;

public interface UserService {
    User create(User user);

    User findById(UUID userId);
}
