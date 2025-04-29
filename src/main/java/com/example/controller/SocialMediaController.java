package com.example.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.service.AccountService;
import com.example.service.MessageService;
import com.example.entity.Message;
import java.util.List;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

    private final AccountService accountService;
    private final MessageService messageService;

    public SocialMediaController(AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }
    
    @PostMapping(path = "/register")
    public ResponseEntity<Account> register(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.register(account));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Account> login(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.login(account));
    }

    @PostMapping(path = "/messages")
    public ResponseEntity<Message> createNewMessage(@RequestBody Message message){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.createNewMessage(message));
    }

    @GetMapping(path = "/messages")
    public ResponseEntity<List<Message>> getAllMessages(){
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.status(HttpStatus.OK).body(messages);
    }

    @GetMapping(path = "/messages/{messageId}")
    public ResponseEntity<Message> getMessageById(@PathVariable("messageId") String messageId) {
        System.err.println(messageId);
        return ResponseEntity.status(HttpStatus.OK).body(messageService.getMessageById(messageId));
    }

    @DeleteMapping(path = "/messages/{messageId}")
    public ResponseEntity<Integer> deleteMessageById(@PathVariable("messageId") String messageId){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.deleteMessageById(messageId));
    }

    @PatchMapping(path = "/messages/{messageId}")
    public ResponseEntity<Integer> updateMessageById(@RequestBody Message message, @PathVariable String messageId) {
        Integer updatedMessage = messageService.updateMessageById(message, messageId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedMessage);
    }

    @GetMapping(path = "/accounts/{accountId}/messages")
    public ResponseEntity<List<Message>> getMessageByAccountId(@PathVariable("accountId") String messageId){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.getMessageByAccountId(messageId));
    }

}
