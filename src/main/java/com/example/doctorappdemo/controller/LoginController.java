package com.example.doctorappdemo.controller;

import com.example.doctorappdemo.entity.User;
import com.example.doctorappdemo.service.SecurityService;
import com.example.doctorappdemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;



    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()){
            return "redirect:/";
        }
        if (error != null)
            model.addAttribute("error", "Your email and password is invalid");

        if (logout != null)
            model.addAttribute("message", "You have been logged out");

        return "login";
    }

}
