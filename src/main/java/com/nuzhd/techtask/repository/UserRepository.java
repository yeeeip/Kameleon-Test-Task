package com.nuzhd.techtask.repository;

import com.nuzhd.techtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
