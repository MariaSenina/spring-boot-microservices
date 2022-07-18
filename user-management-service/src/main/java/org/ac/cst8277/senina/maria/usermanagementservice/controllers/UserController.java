package org.ac.cst8277.senina.maria.usermanagementservice.controllers;

import org.ac.cst8277.senina.maria.usermanagementservice.dtos.SubscriptionsResponseDto;
import org.ac.cst8277.senina.maria.usermanagementservice.dtos.UserDto;
import org.ac.cst8277.senina.maria.usermanagementservice.entities.User;
import org.ac.cst8277.senina.maria.usermanagementservice.services.UserService;
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
    public SubscriptionsResponseDto findSubscriptionsByUserId(@PathVariable Integer id) {
        return userService.findSubscriptionsByUserId(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }
}
