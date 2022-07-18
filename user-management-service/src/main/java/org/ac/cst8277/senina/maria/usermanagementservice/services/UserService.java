package org.ac.cst8277.senina.maria.usermanagementservice.services;

import org.ac.cst8277.senina.maria.usermanagementservice.dtos.SubscriptionsResponseDto;
import org.ac.cst8277.senina.maria.usermanagementservice.dtos.UserDto;
import org.ac.cst8277.senina.maria.usermanagementservice.entities.User;
import org.ac.cst8277.senina.maria.usermanagementservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private UserRepository userRepository;
    private SubscriptionService subscriptionService;

    @Autowired
    public UserService(UserRepository loginRepository, SubscriptionService subscriptionService) {
        this.userRepository = loginRepository;
        this.subscriptionService = subscriptionService;
    }

    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public SubscriptionsResponseDto findSubscriptionsByUserId(int id) {
        SubscriptionsResponseDto responseDto = new SubscriptionsResponseDto();
        responseDto.setSubscriptions(subscriptionService.findSubscriptionsByUserId(id));

        return responseDto;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        return userRepository.save(user);
    }
}
