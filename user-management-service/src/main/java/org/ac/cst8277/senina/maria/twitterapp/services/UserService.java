package org.ac.cst8277.senina.maria.twitterapp.services;

import org.ac.cst8277.senina.maria.twitterapp.dtos.UserDto;
import org.ac.cst8277.senina.maria.twitterapp.entities.User;
import org.ac.cst8277.senina.maria.twitterapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository loginRepository) {
        this.userRepository = loginRepository;
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password)
                .orElseThrow( () ->
                        new EntityNotFoundException("User with email: " + email + " and password: " + password + " not found") );
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
