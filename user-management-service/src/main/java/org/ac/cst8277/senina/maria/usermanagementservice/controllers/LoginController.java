package org.ac.cst8277.senina.maria.usermanagementservice.controllers;

import org.ac.cst8277.senina.maria.usermanagementservice.dtos.ErrorResponseDto;
import org.ac.cst8277.senina.maria.usermanagementservice.dtos.LoginRequestDto;
import org.ac.cst8277.senina.maria.usermanagementservice.dtos.TokenResponseDto;
import org.ac.cst8277.senina.maria.usermanagementservice.entities.User;
import org.ac.cst8277.senina.maria.usermanagementservice.services.AuthService;
import org.ac.cst8277.senina.maria.usermanagementservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class LoginController {
    private UserService loginService;
    private AuthService authService;

    @Autowired
    public LoginController(UserService loginService, AuthService authService) {
        this.loginService = loginService;
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Object> doLogin(LoginRequestDto requestDto) {
        Optional<User> user = loginService.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword());
        ResponseEntity<Object> response;

        if (user.isPresent()) {
            String token = UUID.randomUUID().toString();
            authService.setTokenForUser(user.get().getId(), token);
            TokenResponseDto responseDto = new TokenResponseDto();
            responseDto.setToken(token);
            response = ResponseEntity.ok().body(responseDto);
        } else {
            response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponseDto("login failed - unauthorized"));
        }

        return response;
    }
}
