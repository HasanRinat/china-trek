package com.chinatrek.service;

import com.chinatrek.model.Location;
import com.chinatrek.model.User;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    
    public User register(String email, String username) {
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
    
    public int calculatePoints(int attemptNumber) {
        if (attemptNumber == 1) return 10;
        if (attemptNumber == 2) return 5;
        return 0;
    }
    
    public User moveToNextLocation(String email) {
        User user = users.get(email);
        if (user == null) return null;
        
        Location current = Location.values()[user.getCurrentLocationIndex()];
        if (current == Location.FINISH) return user;
        
        int moveCost = 20;
        if (user.getBalance() < moveCost) {
            throw new IllegalStateException("Недостаточно баллов!");
        }
        
        user.setBalance(user.getBalance() - moveCost);
        user.setCurrentLocationIndex(user.getCurrentLocationIndex() + 1);
        return user;
    }
    
    public User earnPoints(String email, int attemptNumber) {
        User user = users.get(email);
        if (user == null) return null;
        
        int points = calculatePoints(attemptNumber);
        user.setBalance(user.getBalance() + points);
        return user;
    }
}
