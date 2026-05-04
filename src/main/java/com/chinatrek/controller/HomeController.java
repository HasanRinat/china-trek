package com.chinatrek.controller;

import com.chinatrek.model.User;
import com.chinatrek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String home() {
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
    public String mapPage(@RequestParam String email, Model model) {
        User user = userService.getUser(email);
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "map";
    }
    
    @GetMapping("/quiz")
    public String quizPage(@RequestParam String email, @RequestParam int locationIndex, Model model) {
        User user = userService.getUser(email);
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        model.addAttribute("locationIndex", locationIndex);
        return "quiz";
    }
}
