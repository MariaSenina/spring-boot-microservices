package org.ac.cst8277.senina.maria.twitterapp.controllers;

import org.ac.cst8277.senina.maria.twitterapp.dtos.UserDto;
import org.ac.cst8277.senina.maria.twitterapp.entities.Subscription;
import org.ac.cst8277.senina.maria.twitterapp.entities.User;
import org.ac.cst8277.senina.maria.twitterapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}/subscriptions")
    public List<Subscription> findSubscriptionsByUserId(@PathVariable Integer id) {
        return userService.findSubscriptionsByUserId(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }
}
