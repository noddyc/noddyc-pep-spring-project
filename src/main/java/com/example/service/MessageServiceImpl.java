package com.example.service;

import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;
import com.example.entity.Account;
import com.example.entity.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepository;
    private final AccountRepository accountRepository;

    public MessageServiceImpl(MessageRepository messageRepository, AccountRepository accountRepository){
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;

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
        //try catch 
        // try{   
        //     Message msg = messageRepository.save(message);
        //     return Optional.of(msg);
        // }catch(Exception ex){
        //     throw ex;
        // }
        Message addedMessage = messageRepository.save(message);
        return Optional.of(addedMessage);
    }

    @Override
    public Optional<Message> getMessageById(int messageId) {
        // Integer id;
        // try{
        //     id = Integer.parseInt(idParam);
        // }catch (NumberFormatException e) {
        //     return Optional.empty();
        // }

        return messageRepository.findById(messageId);
    }

    @Override
    public Message deleteMessageById(int messageId) {
        // Integer id;
        // try{
        //     id = Integer.parseInt(idParam);
        // }catch (NumberFormatException e) {
        //     return Optional.empty();
        // }

        Optional<Message> deletedMessage = getMessageById(messageId);
        if(deletedMessage.isEmpty()){
            return null;
        }else{
            messageRepository.deleteById(messageId);
            return deletedMessage.get();
        }
    }

    @Override
    public Message updateMessageById(Message message, int messageId) {
                //      Integer id;
        // try{
        //     id = Integer.parseInt(idParam);
        // }catch (NumberFormatException e) {
        //     return new ArrayList<>();
        // }

        if(message.getMessageText() == null || 
        message.getMessageText().isEmpty() || 
        message.getMessageText().length() > 255){
            return null;
        }

        Optional<Message> toBeUpdatedMessage = getMessageById(messageId);
        if(toBeUpdatedMessage.isEmpty()){
            return null;
        }else{
            try{
                toBeUpdatedMessage.get().setMessageText(message.getMessageText());
                return messageRepository.save(toBeUpdatedMessage.get());
            }catch(Exception ex){
                throw ex;
            }
        }
    }

    @Override
    public List<Message> getMessageByAccountId(int accountId) {
        //      Integer id;
        // try{
        //     id = Integer.parseInt(idParam);
        // }catch (NumberFormatException e) {
        //     return new ArrayList<>();
        // }
        return messageRepository.findAllByPostedBy(accountId);
    }

    



    
    
}
