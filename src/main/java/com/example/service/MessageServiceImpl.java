package com.example.service;

import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;
import com.example.entity.Account;
import com.example.entity.Message;
import com.example.exception.ClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepository;
    private final AccountRepository accountRepository;

    public MessageServiceImpl(MessageRepository messageRepository, AccountRepository accountRepository){
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Message createNewMessage(Message message) {
        if(message.getMessageText() == null ||
        message.getMessageText().isEmpty() || 
        message.getMessageText().length() > 255){
            throw new ClientErrorException("Message text should not be blank or over 255 characters");
        }else{
            Optional<Account> accountExisted = accountRepository.findByAccountId(message.getPostedBy());
            if(accountExisted.isEmpty()){
                throw new ClientErrorException("Account does not exist");
            }else{
                try{   
                    Message addedMessage = messageRepository.save(message);
                    return addedMessage;
                }catch(Exception ex){
                    throw new ClientErrorException("Fail to create message");
                }
            }
        }
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message getMessageById(String messageId) {
        Integer id;
        try{
            id = Integer.parseInt(messageId);
        }catch (NumberFormatException e) {
            throw new ClientErrorException("Fail to retrieve a message by id");
        }
        return messageRepository.findByMessageId(id).orElse(null);
    }

    @Override
    public Integer deleteMessageById(String messageId) {

        Message deletedMessage = getMessageById(messageId);

        if(deletedMessage == null){
            return null;
        }else{
            try{
                Integer id;
                id = Integer.parseInt(messageId);
                messageRepository.deleteById(id);
                return 1;
            }catch (Exception e){
                throw new ClientErrorException("Fail to delete a message by id");
            }
        }
    }

    @Override
    public Integer updateMessageById(Message message, String messageId) {
        if(message.getMessageText() == null || 
        message.getMessageText().isEmpty() || 
        message.getMessageText().length() > 255){
            throw new ClientErrorException("Fail to update message");
        }else{
            Message toBeUpdatedMessage = getMessageById(messageId);
            
            if(toBeUpdatedMessage == null){
                throw new ClientErrorException("Fail to update message");
            }else{
                try{
                    toBeUpdatedMessage.setMessageText(message.getMessageText());
                    messageRepository.save(toBeUpdatedMessage);
                    return 1;
                }catch(Exception ex){
                    throw new ClientErrorException("Fail to update message");
                }
            }
        }
    }

    @Override
    public List<Message> getMessageByAccountId(String accountId) {
        Integer id;
        try{
            id = Integer.parseInt(accountId);
        }catch (NumberFormatException e) {
            throw new ClientErrorException("Fail to get message by account id");
        }
        return messageRepository.findAllByPostedBy(id);
    }

    



    
    
}
