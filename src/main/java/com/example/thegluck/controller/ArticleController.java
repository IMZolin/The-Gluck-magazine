package com.example.thegluck.controller;

import com.example.thegluck.entity.ArticleEntity;
import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.UserAlreadyExistException;
import com.example.thegluck.repos.ArticleRepo;
import com.example.thegluck.service.ArticleService;
import com.example.thegluck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("article/{id}")
    public ArticleEntity getOne(@PathVariable("id") ArticleEntity user) {
        return user;
    }
//    @PostMapping("editor")
//    public ResponseEntity registration(@RequestBody UserEntity user) {
//        try {
//            userService.signup(user);
//            return ResponseEntity.ok("User was saved");
//        } catch (UserAlreadyExistException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error");
//        }
//    }
}
