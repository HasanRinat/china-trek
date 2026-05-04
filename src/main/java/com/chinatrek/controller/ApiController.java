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
        System.out.println("✅✅✅ ApiController РАБОТАЕТ! ✅✅✅");
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
        User user = userService.register(email, username);
        return user;
    }

    @PostMapping("/login")
    public User login(@RequestParam String email) {
        System.out.println("🔐 Login вызван: " + email);
        return userService.login(email);
    }
    
    // Тестовый эндпоинт - проверяем, что контроллер вообще загрузился
    @GetMapping("/test")
    public String test() {
        return "API работает!";
    }
}
