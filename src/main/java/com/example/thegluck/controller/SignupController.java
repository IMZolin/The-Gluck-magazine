package com.example.thegluck.controller;
import com.example.thegluck.domain.Role;
import com.example.thegluck.domain.User;
import com.example.thegluck.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class SignupController {
//    @Autowired
//    private UserRepo userRepo;
//    @PostMapping("/signup")
//    public String addUser(User user, Map<String, Object> model) {
//        User userFromDb = userRepo.findByEmail(user.getEmail());
//
//        if (userFromDb != null) {
////            model.put("message", "User exists!");
//            return "signup";
//        }
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
//        userRepo.save(user);
//        return "redirect:/login";
//    }
}
