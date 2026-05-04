package com.chinatrek.service;

import com.chinatrek.model.User;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    // Хранилище пользователей в памяти
    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
    
    public User register(String email, String username) {
        if (users.containsKey(email)) {
            return null; // Пользователь уже существует
        }
        User user = new User(email, username);
        users.put(email, user);
        return user;
    }
    
    public User login(String email) {
        return users.get(email);
    }
    
    public User getUser(String email) {
        return users.get(email);
    }
    
    public User updateBalance(String email, int newBalance) {
        User user = users.get(email);
        if (user != null) {
            user.setBalance(newBalance);
        }
        return user;
    }
}
