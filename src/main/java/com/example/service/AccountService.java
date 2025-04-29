package com.example.service;

import com.example.entity.Account;

/**
 * Service layer for account 
 */
public interface AccountService {
    
    Account register(Account account);

    Account login(Account account);
}
