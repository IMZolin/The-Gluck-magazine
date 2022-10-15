package com.example.thegluck.service;

import com.example.thegluck.exception.NotMatchPasswordException;
import com.example.thegluck.model.User;
import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.UserAlreadyExistException;
import com.example.thegluck.exception.UserNotFoundException;
import com.example.thegluck.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

//    public UserEntity signup(UserEntity user) throws UserAlreadyExistException {
//        if (userRepo.findByEmail(user.getEmail()) != null) {
//            throw new UserAlreadyExistException("User with this email have already registered");
//        }
//        return userRepo.save(user);
//    }
    public UserEntity signup(String username, String first_name, String last_name, String email, String password, String password_confirm) throws NotMatchPasswordException, UserAlreadyExistException {
        if (userRepo.findByEmail(email) != null)
            throw new UserAlreadyExistException("User with this email have already registered");
        if(!Objects.equals(password,password_confirm))
            throw new NotMatchPasswordException("Passwords don't match");
        return userRepo.save(
                UserEntity.of(username,first_name,last_name, email,password)
        );
    }

    public String login(UserEntity user) throws UserNotFoundException {
        UserEntity checkingUser = (UserEntity) userRepo.findByEmail(user.getEmail());
        if (checkingUser == null) {
            throw new UserNotFoundException("User with this email has not been registered yet");
        }
        if (!checkingUser.getPassword().equals(user.getPassword())) {
            throw new UserNotFoundException("User with this email had different password");
        }
        return checkingUser.getUsername();
    }

    public User getByEmail(String email) throws UserNotFoundException{
        UserEntity user = (UserEntity) userRepo.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User was not found");
        }
        return User.toModel(user);
    }
    public List<UserEntity> getAll(){
        List<UserEntity> users = userRepo.findAll();
        return users;
    }
    public User getByUsername(String username) throws UserNotFoundException {
        UserEntity user = (UserEntity) userRepo.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User was not found");
        }
        return User.toModel(user);
    }
}