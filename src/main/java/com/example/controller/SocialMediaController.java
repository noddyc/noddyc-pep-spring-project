package com.example.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        System.err.print("postmapping register");
        Optional<Account> registeredAccount = accountService.register(account);
        if(registeredAccount.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }else{
            return ResponseEntity.ok(registeredAccount.get());
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Account> login(@RequestBody Account account){
        System.err.print("postmapping login");
        Optional<Account> loggedInAccount = accountService.login(account);
        if(loggedInAccount.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(loggedInAccount.get());
        }
    }

  
    @PostMapping(path = "/messages")
    public ResponseEntity<List<Message>> createNewMessage(@RequestBody Message message){
        System.err.print("postmapping createNew Message");
        messageService.createNewMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    @GetMapping(path = "/messages")
    public ResponseEntity<List<Message>> getAllMessages(){
        System.err.print("postmapping login");
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.status(HttpStatus.OK).body(messages);
    }




}
