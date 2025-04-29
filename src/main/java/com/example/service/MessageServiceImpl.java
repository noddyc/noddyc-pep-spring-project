package com.example.service;

import com.example.repository.MessageRepository;
import com.example.entity.Account;
import com.example.entity.Message;
import java.util.List;
import java.util.Optional;

public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> createNewMessage(Message message) {
        if(message.getMessageText() == null ||
        message.getMessageText().isEmpty() || 
        message.getMessageText().length() > 255){
            return Optional.empty();
        }
        Optional<Account> accountExisted = accountRepository.findByAccountId(message.getPostedBy());

    }



    
    
}
