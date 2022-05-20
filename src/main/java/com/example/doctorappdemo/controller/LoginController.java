package com.example.doctorappdemo.controller;


import com.example.doctorappdemo.entity.User;

import com.example.doctorappdemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    private UserService userService;


    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(name = "user") User user, Model model) {

        String email = user.getEmail();
        String password = user.getPassword();
        System.out.println("user-> " + user);
        User userDB = userService.findUserByEmail(email);
        System.out.println("DB user-> " + userDB);

        if (email.equals(userDB.getEmail()) && password.equals(userDB.getPassword())) {
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            return "index";
        } else {

            model.addAttribute("error", "incorect email or password");

            return "login";
        }
    }

}
