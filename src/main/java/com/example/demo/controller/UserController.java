package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String postRegister(@ModelAttribute User user) {
        if (userRepository.findUserByUsername(user.getUsername()) != null) {
            return "Username taken";
        }
        userRepository.save(user);
        return String.valueOf(user);
    }

    @GetMapping("/login")
    public String viewUserLoginPage() {
        return "user/user_login";
    }

    @GetMapping("/user")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/user/home")
    public String viewUserHomePage(Model model) {
        var customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username", customUserDetails.getUsername());
        model.addAttribute("password", customUserDetails.getPassword());
        return "user/user_home";
    }
}
