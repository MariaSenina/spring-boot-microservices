package org.ac.cst8277.senina.maria.twitterapp.controllers;

import org.ac.cst8277.senina.maria.twitterapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {
    private AuthService authService;

    @Autowired
    public AuthorizationController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<Object> authorize(@RequestParam Integer id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        if (authService.authorize(id, token)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
