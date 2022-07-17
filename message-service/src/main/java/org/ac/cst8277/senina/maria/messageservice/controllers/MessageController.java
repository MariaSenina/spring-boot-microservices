package org.ac.cst8277.senina.maria.messageservice.controllers;

import org.ac.cst8277.senina.maria.messageservice.entities.Message;
import org.ac.cst8277.senina.maria.messageservice.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public List<Message> findAllMessages() {
        return messageService.findAllMessages();
    }

    @GetMapping("/messages/{id}")
    public List<Message> findAllMessagesForProducer(@PathVariable int id) {
        return messageService.findAllMessagesForProducer(id);
    }
}
