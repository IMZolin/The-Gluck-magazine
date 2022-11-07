package com.example.thegluck.service;

import com.example.thegluck.entity.RoleEntity;
import com.example.thegluck.exception.NotMatchPasswordException;
import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.UserAlreadyExistException;
import com.example.thegluck.exception.UserNotFoundException;
import com.example.thegluck.model.ERole;
import com.example.thegluck.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity signup(String username, String first_name, String last_name, String email, String password, String password_confirm) throws NotMatchPasswordException, UserAlreadyExistException {
        if (userRepo.findByEmail(email) != null)
            throw new UserAlreadyExistException("User with this email have already registered");
        if (userRepo.findByUsername(username) != null)
            throw new UserAlreadyExistException("User with this username have already registered");
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
}
