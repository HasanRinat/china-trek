package com.chinatrek.model;

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
        this.currentLocationIndex = 0;  // Первая локация
        this.character = "🐼 Панда";
    }
    
    // Геттеры и сеттеры
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
    
    public int getCurrentLocationIndex() { return currentLocationIndex; }
    public void setCurrentLocationIndex(int currentLocationIndex) { 
        this.currentLocationIndex = currentLocationIndex; 
    }
    
    public String getCharacter() { return character; }
    public void setCharacter(String character) { this.character = character; }
}
