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
        System.out.println("Регистрация: " + email + ", " + username); // Отладка
        return userService.register(email, username);
    }
    
    @PostMapping("/login")
    public User login(@RequestParam String email) {
        System.out.println("Вход: " + email); // Отладка
        return userService.login(email);
    }
}
