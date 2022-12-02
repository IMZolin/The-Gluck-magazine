package com.example.thegluck.controller;

import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.model.User;
import com.example.thegluck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public UserEntity getOne(@PathVariable("id") UserEntity user) {
        return user;
    }
    /*@GetMapping
    public ResponseEntity getUserByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(userService.getByEmail(email));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }*/
}