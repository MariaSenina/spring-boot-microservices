package org.ac.cst8277.senina.maria.messageservice.services;

import org.ac.cst8277.senina.maria.messageservice.dtos.MessagesResponseDto;
import org.ac.cst8277.senina.maria.messageservice.dtos.SubscriptionDto;
import org.ac.cst8277.senina.maria.messageservice.dtos.SubscriptionResponseDto;
import org.ac.cst8277.senina.maria.messageservice.entities.Message;
import org.ac.cst8277.senina.maria.messageservice.repositories.MessageRepository;
import org.ac.cst8277.senina.maria.messageservice.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {
    private final Integer USER_ID = 1;
    private final Integer PRODUCER_ID = 2;

    @Mock
    private MessageRepository messageRepository;
    @Mock
    private UserRepository userRepository;

    private MessageService messageService;

    @BeforeEach
    void setUp() {
        messageService = new MessageService(messageRepository, userRepository);
    }

    @Test
    void shouldReturnMessageResponseDtoWhenMessagesFound() {
        when(messageRepository.findAll()).thenReturn(Arrays.asList(new Message(), new Message()));

        MessagesResponseDto result = messageService.findAllMessages();

        assertEquals(2, result.getMessages().size());
    }

    @Test
    void shouldReturnMessageResponseDtoWhenMessagesNotFound() {
        MessagesResponseDto result = messageService.findAllMessages();

        assertNotNull(result);
    }

    @Test
    void shouldCallFindAllMessagesByProducerIdWithSameParameters() {
        messageService.findAllMessagesForProducer(USER_ID);

        verify(messageRepository).findAllMessagesByProducerId(USER_ID);
    }

    @Test
    void shouldReturnMessageResponseDtoWhenMessagesForProducerFound() {
        when(messageRepository.findAllMessagesByProducerId(USER_ID))
                .thenReturn(Arrays.asList(new Message()));

        MessagesResponseDto result = messageService.findAllMessagesForProducer(USER_ID);

        assertEquals(1, result.getMessages().size());
    }

    @Test
    void shouldReturnMessageResponseDtoWhenMessagesForProducerNotFound() {
        MessagesResponseDto result = messageService.findAllMessagesForProducer(USER_ID);

        assertNotNull(result);
    }

    @Test
    void shouldCallFindAllMessagesBySubscriberIdWithSameParameters() {
        SubscriptionResponseDto responseDto = Mockito.mock(SubscriptionResponseDto.class);

        when(userRepository.findSubscriptionsByUserId(USER_ID)).thenReturn(responseDto);

        messageService.findMessagesForSubscriber(USER_ID);

        verify(userRepository).findSubscriptionsByUserId(USER_ID);
    }

    @Test
    void shouldReturnEmptyListOfMessagesWhenProducerListIsEmpty() {
        SubscriptionResponseDto responseDto = Mockito.mock(SubscriptionResponseDto.class);

        when(userRepository.findSubscriptionsByUserId(USER_ID)).thenReturn(responseDto);
        when(responseDto.getSubscriptions()).thenReturn(new ArrayList());

        MessagesResponseDto result = messageService.findMessagesForSubscriber(USER_ID);

        assertEquals(0, result.getMessages().size());
    }

    @Test
    void shouldReturnMessagesWhenSubscriberHasProducers() {
        SubscriptionResponseDto responseDto = Mockito.mock(SubscriptionResponseDto.class);
        SubscriptionDto subscriptionDto = Mockito.mock(SubscriptionDto.class);
        List<SubscriptionDto> subscriptions = Arrays.asList(subscriptionDto);

        when(userRepository.findSubscriptionsByUserId(USER_ID)).thenReturn(responseDto);
        when(responseDto.getSubscriptions()).thenReturn(subscriptions);
        when(subscriptionDto.getProducerId()).thenReturn(PRODUCER_ID);
        when(messageRepository.findAllMessagesByProducerId(PRODUCER_ID)).thenReturn(Arrays.asList(new Message(), new Message()));

        MessagesResponseDto result = messageService.findMessagesForSubscriber(USER_ID);

        assertEquals(2, result.getMessages().size());
    }
}