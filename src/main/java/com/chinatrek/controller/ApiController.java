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
        System.out.println("=== РЕГИСТРАЦИЯ ===");
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
        User user = userService.register(email, username);
        System.out.println("Результат: " + (user != null ? "Успех" : "Ошибка"));
        return user;
    }

    @PostMapping("/login")
    public User login(@RequestParam String email) {
        System.out.println("=== ВХОД ===");
        System.out.println("Email: " + email);
        User user = userService.login(email);
        System.out.println("Результат: " + (user != null ? "Найден" : "Не найден"));
        return user;
    }
}
