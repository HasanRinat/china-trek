package com.chinatrek.controller;

import com.chinatrek.model.Location;
import com.chinatrek.model.User;
import com.chinatrek.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {
    
    @Autowired
    private GameService gameService;
    
    // Страницы
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @GetMapping("/map")
    public String mapPage(@RequestParam(required = false) String email, Model model) {
        if (email == null) return "redirect:/";
        User user = gameService.getUser(email);
        model.addAttribute("user", user);
        model.addAttribute("locations", Location.values());
        model.addAttribute("currentLocation", Location.values()[user.getCurrentLocationIndex()]);
        return "map";
    }
    
    @GetMapping("/quiz")
    public String quizPage(@RequestParam String email, @RequestParam int locationIndex, Model model) {
        User user = gameService.getUser(email);
        model.addAttribute("user", user);
        model.addAttribute("location", Location.values()[locationIndex]);
        model.addAttribute("attempt", 1);
        return "quiz";
    }
    
    // API для AJAX запросов
    @PostMapping("/api/register")
    @ResponseBody
    public User register(@RequestParam String email, @RequestParam String username) {
        return gameService.register(email, username);
    }
    
    @PostMapping("/api/login")
    @ResponseBody
    public User login(@RequestParam String email) {
        return gameService.login(email);
    }
    
    @PostMapping("/api/move")
    @ResponseBody
    public User move(@RequestParam String email) {
        return gameService.moveToNextLocation(email);
    }
    
    @PostMapping("/api/answer")
    @ResponseBody
    public User answer(@RequestParam String email, @RequestParam int attempt) {
        return gameService.earnPoints(email, attempt);
    }
}
