package org.ac.cst8277.senina.maria.messageservice.controllers;

import org.ac.cst8277.senina.maria.messageservice.dtos.MessagesResponseDto;
import org.ac.cst8277.senina.maria.messageservice.entities.Message;
import org.ac.cst8277.senina.maria.messageservice.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> findAllMessages() {
        return messageService.findAllMessages();
    }

    @GetMapping("/producer/{id}")
    public List<Message> findAllMessagesForProducer(@PathVariable Integer id) {
        return messageService.findAllMessagesForProducer(id);
    }

    @GetMapping("/subscriber/{id}")
    public MessagesResponseDto findMessagesForSubscriber(@PathVariable Integer id) {
        return messageService.findMessagesForSubscriber(id);
    }
}
