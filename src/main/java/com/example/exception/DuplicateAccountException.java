package com.example.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception representing a duplicated account error (HTTP 409).
 */
public class DuplicateAccountException extends CustomException{

    public DuplicateAccountException(String message) {
        super(message);
        this.status = HttpStatus.CONFLICT;
    }

}
