package com.nuzhd.task.model;

import lombok.Getter;

@Getter
public class UserCreationRequest {

    private String username;
    private String email;
    private String password;

    public UserCreationRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
