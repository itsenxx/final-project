package org.juice_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/login")
    public String login(){
        return "home/login";
    }

    @GetMapping("/login-failure")
    public String loginFail() {
        return "home/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "home/login";
    }
}
