package com.example.service;

import com.example.entity.Account;

/**
 * Service layer for account 
 */
public interface AccountService {
    
    /**
     * method to register
     * @param account
     * @return registered account
     */
    Account register(Account account);

    /**
     * method to login
     * @param account
     * @return logged in account
     */
    Account login(Account account);
}
