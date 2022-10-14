package com.example.thegluck.controller;

import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.UserAlreadyExistException;
import com.example.thegluck.exception.UserNotFoundException;
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

    @PostMapping("signup")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.signup(user);
            return ResponseEntity.ok("User was saved");
        } catch (UserAlreadyExistException e) {
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
    public List<UserEntity> getUsers(){
        return userService.getAll();
    };
//    @GetMapping(value = "/username")
//    public List<UserEntity> getByUsername(@RequestParam String username){
//        return userService.getAll();
//    };
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
//            return ResponseEntity.ok(userService.getByUserName(username));
//        } catch (UserNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error");
//        }
//    }
}