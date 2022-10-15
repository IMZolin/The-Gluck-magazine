package com.example.thegluck.model;

import com.example.thegluck.entity.UserEntity;

public class User {
    private Long id;
    private String username;
    public User() {}
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        return model;
    }
}
