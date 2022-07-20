package org.ac.cst8277.senina.maria.messageservice.services;

import org.ac.cst8277.senina.maria.messageservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HttpStatus authorizeUser(Integer id, String token) {
        return userRepository.authorize(id, token);
    }
}
