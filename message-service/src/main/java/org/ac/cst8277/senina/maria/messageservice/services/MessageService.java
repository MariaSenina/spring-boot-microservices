package org.ac.cst8277.senina.maria.messageservice.services;

import org.ac.cst8277.senina.maria.messageservice.dtos.MessagesResponseDto;
import org.ac.cst8277.senina.maria.messageservice.entities.Message;
import org.ac.cst8277.senina.maria.messageservice.repositories.MessageRepository;
import org.ac.cst8277.senina.maria.messageservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    private UserRepository userRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public MessagesResponseDto findAllMessages() {
        List<Message> messages = new ArrayList();
        messageRepository.findAll().forEach(message -> messages.add(message));

        return mapToMessagesResponseDto(messages);
    }

    public MessagesResponseDto findAllMessagesForProducer(int id) {
        List<Message> messages = new ArrayList();
        messageRepository.findAllMessagesByProducerId(id).forEach(message -> messages.add(message));

        return mapToMessagesResponseDto(messages);
    }

    public MessagesResponseDto findMessagesForSubscriber(Integer id) {
        List<Message> messages = new ArrayList();

        userRepository.findSubscriptionsByUserId(id)
                .getSubscriptions().forEach(subscription -> {
                    int producerId = subscription.getProducerId();
                    messageRepository.findAllMessagesByProducerId(producerId).forEach(message -> messages.add(message));
                });

        return mapToMessagesResponseDto(messages);
    }

    private MessagesResponseDto mapToMessagesResponseDto(List<Message> messages) {
        MessagesResponseDto responseDto = new MessagesResponseDto();
        responseDto.setMessages(messages);

        return responseDto;
    }
}
