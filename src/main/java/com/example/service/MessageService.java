package com.example.service;
import com.example.entity.Message;
import java.util.List;
import java.util.Optional;

public interface MessageService {

    Optional<Message> createNewMessage(Message message);
    
    List<Message> getAllMessages();
}
