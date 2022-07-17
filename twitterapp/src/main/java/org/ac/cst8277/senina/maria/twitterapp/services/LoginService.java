package org.ac.cst8277.senina.maria.twitterapp.services;

import org.ac.cst8277.senina.maria.twitterapp.entities.User;
import org.ac.cst8277.senina.maria.twitterapp.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class LoginService {
    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public User findByEmailAndPassword(String email, String password) {
        return loginRepository.findByEmailAndPassword(email, password)
                .orElseThrow( () ->
                        new EntityNotFoundException("User with email: " + email + " and password: " + password + " not found") );
    }
}
