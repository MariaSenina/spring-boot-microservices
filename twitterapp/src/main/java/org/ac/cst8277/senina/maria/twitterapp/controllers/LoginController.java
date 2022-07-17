package org.ac.cst8277.senina.maria.twitterapp.controllers;

import org.ac.cst8277.senina.maria.twitterapp.dtos.LoginRequestDto;
import org.ac.cst8277.senina.maria.twitterapp.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String doLogin(LoginRequestDto requestDto) {
        System.out.println(loginService.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword()));
        return "login";
    }
}
