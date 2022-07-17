package org.ac.cst8277.senina.maria.twitterapp.controllers;

import org.ac.cst8277.senina.maria.twitterapp.dtos.LoginRequestDto;
import org.ac.cst8277.senina.maria.twitterapp.entities.User;
import org.ac.cst8277.senina.maria.twitterapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    private UserService loginService;

    @Autowired
    public LoginController(UserService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String doLogin(LoginRequestDto requestDto, Model model) {
        User user = loginService.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword());
        model.addAttribute("user", user);

        return "userHome";
    }
}
