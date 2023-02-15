package com.nuzhd.techtask.service;

import com.nuzhd.techtask.model.User;

import java.util.UUID;

public interface UserService {
    User create(User user);

    User findById(UUID userId);
}
