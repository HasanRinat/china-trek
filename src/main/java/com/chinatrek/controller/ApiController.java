package com.chinatrek.controller;

import com.chinatrek.model.User;
import com.chinatrek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public User register(@RequestParam String email, @RequestParam String username) {
        return userService.register(email, username);
    }
    
    @PostMapping("/login")
    public User login(@RequestParam String email) {
        return userService.login(email);
    }
    
    @PostMapping("/move")
    public User move(@RequestParam String email) {
        User user = userService.getUser(email);
        if (user != null && user.getBalance() >= 20) {
            int newBalance = user.getBalance() - 20;
            user.setBalance(newBalance);
            user.setCurrentLocationIndex(user.getCurrentLocationIndex() + 1);
            return user;
        }
        return user;
    }
    
    @PostMapping("/answer")
    public User answer(@RequestParam String email, @RequestParam int attempt) {
        User user = userService.getUser(email);
        if (user != null) {
            int points = (attempt == 1) ? 10 : (attempt == 2) ? 5 : 0;
            user.setBalance(user.getBalance() + points);
            return user;
        }
        return user;
    }
}
