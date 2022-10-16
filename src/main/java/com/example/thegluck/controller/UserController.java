package com.example.thegluck.controller;

import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.NotMatchPasswordException;
import com.example.thegluck.exception.UserAlreadyExistException;
import com.example.thegluck.exception.UserNotFoundException;
import com.example.thegluck.model.User;
import com.example.thegluck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
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
    @PostMapping(value ="signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) throws UserAlreadyExistException, NotMatchPasswordException {
        try {
            var user = userService.signup(
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
    @PostMapping("login")
    public ResponseEntity login(@RequestBody UserEntity user) {
        try {
            String userName = userService.login(user);
            return ResponseEntity.ok(userName);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
    @GetMapping("users")
    public List<User> getUsers(){
        return userService.getAll();
    };
    @GetMapping("user/{id}")
    public UserEntity getOne(@PathVariable("id") UserEntity user) {
        return user;
    }
    @GetMapping
    public ResponseEntity getUserByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(userService.getByEmail(email));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
//    @GetMapping
//    public ResponseEntity getUserByUsername(@RequestParam String username) {
//        try {
//            return ResponseEntity.ok(userService.getByUsername(username));
//        } catch (UserNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
////        } catch (Exception e) {
////            return ResponseEntity.badRequest().body("Error");
////        }
//    }
}

