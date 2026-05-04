package com.chinatrek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class ChinaTrekApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChinaTrekApplication.class, args);
        System.out.println("Сервер работает!");
    }

    @PostMapping("/api/register")
    public String register(@RequestParam String email, @RequestParam String username) {
        System.out.println("Регистрация: " + email + " / " + username);
        return "{\"status\": \"ok\"}";
    }
}
