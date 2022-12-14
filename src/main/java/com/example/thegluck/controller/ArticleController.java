package com.example.thegluck.controller;

import com.example.thegluck.entity.ArticleEntity;
import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.exception.UserAlreadyExistException;
import com.example.thegluck.model.Article;
import com.example.thegluck.service.ArticleService;
import com.example.thegluck.service.AuthService;
import com.example.thegluck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    private AuthService authService;
    @GetMapping("article/{id}")
    public ArticleEntity getOne(@PathVariable("id") ArticleEntity user) {
        return user;
    }
    @GetMapping("articles")
    public List<Article> getArticles(){
        return articleService.getAll();
    }
    @DeleteMapping("/articles/id")
    void deleteTask(@RequestParam(name = "id") long id){
        articleService.delete(id);
    }

    /*@PostMapping("editor")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            //authService.login(user.getEmail(), user.getPassword());
            return ResponseEntity.ok("User was saved");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }*/
}
