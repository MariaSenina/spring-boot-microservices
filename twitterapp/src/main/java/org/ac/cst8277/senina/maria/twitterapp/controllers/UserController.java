package org.ac.cst8277.senina.maria.twitterapp.controllers;

import org.ac.cst8277.senina.maria.twitterapp.entities.User;
import org.ac.cst8277.senina.maria.twitterapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }
}
