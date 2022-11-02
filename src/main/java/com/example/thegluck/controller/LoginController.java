package com.example.thegluck.controller;

import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.NotMatchPasswordException;
import com.example.thegluck.exception.UserAlreadyExistException;
import com.example.thegluck.exception.UserNotFoundException;
import com.example.thegluck.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;
    record SignupRequest(String username,
                         String first_name,
                         String last_name,
                         String email,
                         String password,
                         String passwordConfirm
    ){}
    record SignupResponse(Long id,
                          String username,
                          String first_name,
                          String last_name,
                          String email
    ){}
    @PostMapping(value ="/auth/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) throws UserAlreadyExistException, NotMatchPasswordException {
        try {
            var user = loginService.signup(
                    signupRequest.username(),
                    signupRequest.first_name(),
                    signupRequest.last_name(),
                    signupRequest.email(),
                    signupRequest.password(),
                    signupRequest.passwordConfirm()
            );
            return ResponseEntity.ok("User was saved");
        } catch (UserAlreadyExistException | NotMatchPasswordException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
    @PostMapping("/auth/login")
    public ResponseEntity login(@RequestBody UserEntity user) {
        try {
            String userName = loginService.login(user);
            return ResponseEntity.ok(userName);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
