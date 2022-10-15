package com.example.thegluck.controller;

import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.UserAlreadyExistException;
import com.example.thegluck.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ArticleController {


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
