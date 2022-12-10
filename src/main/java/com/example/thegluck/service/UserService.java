package com.example.thegluck.service;

import com.example.thegluck.model.User;
import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.UserNotFoundException;
import com.example.thegluck.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User getByEmail(String email) throws UserNotFoundException{
        UserEntity user = (UserEntity) userRepo.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User was not found");
        }
        return User.toModel(user);
    }
    public List<User> getAll(){
        List<UserEntity> users = userRepo.findAll();
        List<User> users_model = new ArrayList<>();
        for (UserEntity user : users){
            users_model.add(User.toModel(user));
        }
        return users_model;
    }
}