package com.example.service;
import com.example.entity.Message;
import java.util.List;
import java.util.Optional;

public interface MessageService {

    Optional<Message> createNewMessage(Message message);
    
    List<Message> getAllMessages();

    Optional<Message> getMessageById(String messageId);

    Message deleteMessageById(String messageId);

    Message updateMessageById(Message message, String messageId);

    List<Message> getMessageByAccountId(String accountId);
}
