package com.example.thegluck.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String index() {
        return "login.html";
    }
}
