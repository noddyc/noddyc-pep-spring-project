package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;

/**
 * DAO layer to interact with Account table
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

    /**
     * method to find account by username
     * @param username
     * @return account
     */
    Optional<Account> findByUsername(String username);

    /**
     * method to find account by account id
     * @param id
     * @return account
     */
    Optional<Account> findByAccountId(Integer id);
}
