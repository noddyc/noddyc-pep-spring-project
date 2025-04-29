package com.example.service;

import com.example.repository.AccountRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.ClientErrorException;
import com.example.exception.CustomException;
import com.example.exception.DuplicateAccountException;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Account register(Account account) {
        // if(true){
        //     throw new CustomException("Username cannot be empty");
        // }
        // Simulate some validation or error
        if(account.getUsername() == null 
        || account.getUsername().isEmpty() 
        || account.getPassword().length() < 4){
            throw new ClientErrorException("Username cannot be blank and password is at least 4 characters long");
        }
        Optional<Account> accountExisted = accountRepository.findByUsername(account.getUsername());
        
        if(accountExisted.isEmpty()){
            try{
                return accountRepository.save(new Account(account.getUsername(), account.getPassword()));
            }catch(Exception ex){
                throw new ClientErrorException("User failed to register");
            }
        }else{
            throw new DuplicateAccountException("Account already existed");
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


