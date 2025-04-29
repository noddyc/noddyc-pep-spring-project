package com.example.service;

import java.util.Optional;

import com.example.entity.Account;

public interface AccountService {
    
    Account register(Account account);
    Optional<Account> login(Account account);
}
