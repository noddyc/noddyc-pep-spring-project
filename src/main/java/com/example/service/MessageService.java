package com.example.service;
import com.example.entity.Message;
import java.util.List;
import java.util.Optional;

public interface MessageService {

    Message createNewMessage(Message message);
    
    List<Message> getAllMessages();

    Message getMessageById(String messageId);

    Integer deleteMessageById(String messageId);

    Integer updateMessageById(Message message, String messageId);

    List<Message> getMessageByAccountId(String accountId);
}
