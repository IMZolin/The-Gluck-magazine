package com.example.thegluck.model;

import com.example.thegluck.entity.UserEntity;
import lombok.ToString;

import java.util.Optional;

@ToString
public class User {
    private Long id;
    private String username;
    private String first_name;
    private String last_name;
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
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setFirst_name(entity.getFirst_name());
        model.setLast_name(entity.getLast_name());
        return model;
    }
}
