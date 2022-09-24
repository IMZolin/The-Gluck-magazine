package com.example.thegluck.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

}
