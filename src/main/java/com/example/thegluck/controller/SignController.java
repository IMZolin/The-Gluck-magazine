package com.example.thegluck.controller;

import com.example.thegluck.repos.UserRepo;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping(value="/api")
public class SignController {
    private final UserRepo userRepo;

    public SignController(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
    }

    @GetMapping(value="/hello")
    public String hello()
    {
        return "Hello!";
    }
    record SignupRequest(@JsonProperty("username") String username,
                         @JsonProperty("first_name") String fist_name,
                         @JsonProperty("last_name")String last_name,
                         String email,
                         String password,
                         boolean active,
                         @JsonProperty("passwordConfirm") String passwordConfirm
    ){}
    record SignupResponse(Long id,
                          @JsonProperty("username") String username,
                         @JsonProperty("first_name") String fist_name,
                         @JsonProperty("last_name")String last_name,
                         String email
    ){}
    @PostMapping(value ="/signup")
    public SignupResponse signup(@RequestBody SignupRequest signupRequest){
        var user = userRepo.save(
                com.example.thegluck.domain.User.of(
                        signupRequest.username(),
                        signupRequest.fist_name(),
                        signupRequest.last_name(),
                        signupRequest.email(),
                        signupRequest.password(),
                        signupRequest.active()
                )
        );
        return new SignupResponse(user.getId(),user.getUsername(),user.getFist_name(), user.getLast_name(),user.getEmail());
    }

}
