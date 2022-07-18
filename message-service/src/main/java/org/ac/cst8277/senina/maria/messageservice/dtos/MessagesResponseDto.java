package org.ac.cst8277.senina.maria.messageservice.dtos;

import org.ac.cst8277.senina.maria.messageservice.entities.Message;

import java.util.List;

public class MessagesResponseDto {
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "MessagesResponseDto{" +
                "messages=" + messages +
                '}';
    }
}
