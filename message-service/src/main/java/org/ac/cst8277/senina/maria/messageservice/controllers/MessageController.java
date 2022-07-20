package org.ac.cst8277.senina.maria.messageservice.controllers;

import org.ac.cst8277.senina.maria.messageservice.dtos.ErrorResponseDto;
import org.ac.cst8277.senina.maria.messageservice.dtos.MessagesResponseDto;
import org.ac.cst8277.senina.maria.messageservice.entities.Message;
import org.ac.cst8277.senina.maria.messageservice.services.AuthService;
import org.ac.cst8277.senina.maria.messageservice.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;
    private AuthService authService;

    @Autowired
    public MessageController(MessageService messageService, AuthService authService) {
        this.messageService = messageService;
        this.authService = authService;
    }

    @GetMapping
    public List<Message> findAllMessages() {
        return messageService.findAllMessages();
    }

    @GetMapping("/producer/{id}")
    public ResponseEntity<Object> findAllMessagesForProducer(@PathVariable Integer id,
                                                             @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        ResponseEntity<Object> response;
        HttpStatus responseStatus = authService.authorizeUser(id, token);

        if (responseStatus == HttpStatus.OK) {
            response = ResponseEntity.ok().body(messageService.findAllMessagesForProducer(id));
        } else {
            response = ResponseEntity.status(responseStatus)
                    .body(new ErrorResponseDto(responseStatus.getReasonPhrase().toLowerCase()));
        }

        return response;
    }

    @GetMapping("/subscriber/{id}")
    public ResponseEntity<Object> findMessagesForSubscriber(@PathVariable Integer id,
                                                         @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        ResponseEntity<Object> response;
        HttpStatus responseStatus = authService.authorizeUser(id, token);
        if (responseStatus == HttpStatus.OK) {
            response = ResponseEntity.ok().body(messageService.findMessagesForSubscriber(id));
        } else {
            response = ResponseEntity.status(responseStatus)
                    .body(new ErrorResponseDto(responseStatus.getReasonPhrase().toLowerCase()));
        }

        return response;
    }
}
