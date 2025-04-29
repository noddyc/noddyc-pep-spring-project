package com.example.service;

import com.example.repository.AccountRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.CustomException;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> register(Account account) {
        // if(true){
        //     throw new CustomException("Username cannot be empty");
        // }
        // Simulate some validation or error
        if(account.getUsername() == null 
        || account.getUsername().isEmpty() 
        || account.getPassword().length() < 4){
            return Optional.empty();
        }
        Optional<Account> accountExisted = accountRepository.findByUsername(account.getUsername());
        if(accountExisted.isEmpty()){
            return Optional.of(accountRepository.save(new Account(account.getUsername(), account.getPassword())));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Account> login(Account account){
        Optional<Account> accountExisted = accountRepository.findByUsername(account.getUsername());
        if(accountExisted.isEmpty()){
            return Optional.empty();
        }else{
            if(accountExisted.get().getUsername().equals(account.getUsername()) && accountExisted.get().getPassword().equals(account.getPassword())){
                return accountExisted;
            }else{
                return Optional.empty();
            }
        }
    }
}


