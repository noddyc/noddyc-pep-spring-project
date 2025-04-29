package com.example.service;

import com.example.repository.AccountRepository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.ClientErrorException;
import com.example.exception.DuplicateAccountException;
import com.example.exception.UnauthorizedException;


/**
 * implementation of the service layer for account 
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Account register(Account account) {
        if(account.getUsername() == null 
        || account.getUsername().isEmpty() 
        || account.getPassword().length() < 4){
            throw new ClientErrorException("Username cannot be blank and password is at least 4 characters long");
        }else{
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
    }

    @Override
    public Account login(Account account){
        Optional<Account> accountExisted = accountRepository.findByUsername(account.getUsername());
        if(accountExisted.isEmpty()){
            throw new UnauthorizedException("Account does not exist");
        }else{
            if(accountExisted.get().getPassword().equals(account.getPassword())){
                return accountExisted.get();
            }else{
                throw new UnauthorizedException("Account password does not match");
            }
        }
    }
}


