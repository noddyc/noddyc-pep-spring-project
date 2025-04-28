package com.example.service;

import com.example.repository.AccountRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.CustomException;

@Service
public class AccountService{

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Optional<Account> register(Account account) {
        if(true){
            throw new CustomException("Username cannot be empty");
        }

        // Simulate some validation or error

        
        // Simulate successful registration
        return Optional.empty();
    }
}


