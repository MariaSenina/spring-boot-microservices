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

    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> findAllMessagesForProducer(int id) {
        return messageRepository.findAllMessagesByProducerId(id);
    }

    public MessagesResponseDto findMessagesForSubscriber(Integer id) {
        MessagesResponseDto responseDto = new MessagesResponseDto();
        List<Message> messages = new ArrayList();

        userRepository.findSubscriptionsByUserId(id)
                .getSubscriptions().forEach(subscription -> {
                    int producerId = subscription.getProducerId();
                    messageRepository.findAllMessagesByProducerId(producerId).forEach(message -> messages.add(message));
                });
        responseDto.setMessages(messages);

        return responseDto;
    }
}
