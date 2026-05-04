package com.chinatrek.model;

import lombok.Data;

@Data
public class User {
    private String email;
    private String username;
    private int balance;
    private int currentLocationIndex;
    private String character;
    
    public User(String email, String username) {
        this.email = email;
        this.username = username;
        this.balance = 100;  // Стартовый баланс
        this.currentLocationIndex = 0;
        this.character = "🐼 Панда";
    }
}
