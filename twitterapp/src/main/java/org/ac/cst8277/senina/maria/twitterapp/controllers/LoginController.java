package org.ac.cst8277.senina.maria.twitterapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String getLoginPage() {
        return "login";
    }
}
