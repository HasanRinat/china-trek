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
        return userService.register(email, username);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email) {
        System.out.println("=== ВХОД ===");
        return userService.login(email);
    }

    @PostMapping("/move")
    public User move(@RequestParam String email) {
        System.out.println("=== ПЕРЕМЕЩЕНИЕ ===");
        User user = userService.getUser(email);
        if (user == null) return null;
        
        int moveCost = 20;
        if (user.getBalance() >= moveCost) {
            user.setBalance(user.getBalance() - moveCost);
            user.setCurrentLocationIndex(user.getCurrentLocationIndex() + 1);
            return userService.updateUser(user);
        }
        return user;
    }

    @PostMapping("/answer")
    public User answer(@RequestParam String email, @RequestParam int attempt) {
        System.out.println("=== ОТВЕТ НА КВИЗ ===");
        System.out.println("Попытка: " + attempt);
        
        User user = userService.getUser(email);
        if (user == null) return null;
        
        // Начисляем баллы за ответ
        int points = 0;
        if (attempt == 1) {
            points = 10;
        } else if (attempt == 2) {
            points = 5;
        }
        
        user.setBalance(user.getBalance() + points);
        userService.updateUser(user);
        
        System.out.println("Начислено баллов: " + points);
        System.out.println("Баланс после ответа: " + user.getBalance());
        
        return user;
    }
    
    // Завершить квиз и переместиться
    @PostMapping("/completeQuiz")
    public User completeQuiz(@RequestParam String email) {
        System.out.println("=== ЗАВЕРШЕНИЕ КВИЗА И ПЕРЕМЕЩЕНИЕ ===");
        
        User user = userService.getUser(email);
        if (user == null) return null;
        
        int moveCost = 20;
        if (user.getBalance() >= moveCost) {
            user.setBalance(user.getBalance() - moveCost);
            user.setCurrentLocationIndex(user.getCurrentLocationIndex() + 1);
            userService.updateUser(user);
            System.out.println("Переход на локацию: " + user.getCurrentLocationIndex());
            System.out.println("Остаток баллов: " + user.getBalance());
        } else {
            System.out.println("Недостаточно баллов для перехода! Нужно: " + moveCost);
        }
        
        return user;
    }
}
