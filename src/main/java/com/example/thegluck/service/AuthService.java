package com.example.thegluck.service;

import com.example.thegluck.exception.NotMatchPasswordException;
import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.UserAlreadyExistException;
import com.example.thegluck.exception.UserNotFoundException;
import com.example.thegluck.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthService {
    @Autowired
    private UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final String accessTokenSecret;
    private final String refreshTokenSecret;
    public AuthService(PasswordEncoder passwordEncoder, @Value("${application.security.access-token-secret}") String accessTokenSecret, @Value("${application.security.refresh-token-secret}") String refreshTokenSecret) {
        this.passwordEncoder = passwordEncoder;
        this.accessTokenSecret = accessTokenSecret;
        this.refreshTokenSecret = refreshTokenSecret;
    }

    public UserEntity signup(String username, String first_name, String last_name, String email, String password, String password_confirm) throws NotMatchPasswordException, UserAlreadyExistException {
        if (userRepo.findByEmail(email) != null)
            throw new UserAlreadyExistException("User with this email have already registered");
        if (userRepo.findByUsername(username) != null)
            throw new UserAlreadyExistException("User with this username have already registered");
        if(!Objects.equals(password,password_confirm))
            throw new NotMatchPasswordException("Passwords don't match");

        return userRepo.save(
                UserEntity.of(username,first_name,last_name, email,passwordEncoder.encode(password))
        );
    }
    public Login login(String email, String password) throws UserNotFoundException {
        UserEntity user = (UserEntity) userRepo.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User with this email has not been registered yet");
        }
        //checkingUser.getPassword()
        if (!passwordEncoder.matches(password,user.getPassword())) {
            throw new UserNotFoundException("User with this email had different password");
        }
        /*return checkingUser.getUsername();*/
        return Login.of(user.getId(),accessTokenSecret, refreshTokenSecret);
    }
}
