package com.example.thegluck.controller;

import com.example.thegluck.repos.UserRepo;
import com.example.thegluck.service.SignService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class SignController {
    private final SignService signService;

    public SignController(UserRepo userRepo, PasswordEncoder passwordEncoder, SignService signService) {
        this.signService = signService;
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
        var user = signService.signup(
                signupRequest.username(),
                signupRequest.fist_name(),
                signupRequest.last_name(),
                signupRequest.email(),
                signupRequest.password(),
                signupRequest.passwordConfirm()
        );
        return new SignupResponse(user.getId(),user.getUsername(),user.getFist_name(), user.getLast_name(),user.getEmail());
    }

    record LoginRequest(String email, String password){}
    record LoginResponse(Long id,
                          @JsonProperty("username") String username,
                          @JsonProperty("first_name") String fist_name,
                          @JsonProperty("last_name")String last_name,
                          String email
    ){}

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        var user = signService.login(loginRequest.email(), loginRequest.password());
        return new LoginResponse(user.getId(),user.getUsername(),user.getFist_name(),user.getLast_name(),user.getEmail());
    }

}
