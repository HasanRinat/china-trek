package com.chinatrek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChinaTrekApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChinaTrekApplication.class, args);
        System.out.println("🎉 Сервер запущен!");
    }
}

