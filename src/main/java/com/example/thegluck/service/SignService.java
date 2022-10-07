package com.example.thegluck.service;

import com.example.thegluck.domain.User;
import com.example.thegluck.repos.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class SignService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public SignService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(String username, String fist_name, String last_name, String email, String password, String passwordConfirm) {
        if (!Objects.equals(password, passwordConfirm))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "passwords don't match");
        return userRepo.save(
                User.of(username, fist_name, last_name, email, passwordEncoder.encode(password))
        );
    }
    public User login(String email, String password){
        var user = userRepo.findByEmail(email)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid credentials"));
        if(passwordEncoder.matches(password, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid credentials");
        return null;
    }
}
