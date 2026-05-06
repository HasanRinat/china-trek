package com.chinatrek.service;

import com.chinatrek.model.User;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
    
    public User register(String email, String username) {
        if (users.containsKey(email)) {
            System.out.println("Пользователь уже существует: " + email);
            return null;
        }
        User user = new User(email, username);
        users.put(email, user);
        System.out.println("Зарегистрирован: " + email + " (всего пользователей: " + users.size() + ")");
        return user;
    }
    
    public User login(String email) {
        User user = users.get(email);
        System.out.println("Вход: " + email + " -> " + (user != null ? "найден" : "не найден"));
        return user;
    }
    
    public User getUser(String email) {
        return users.get(email);
    }
    public User updateUser(User user) {
    return userRepository.save(user);
}
}
