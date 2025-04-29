package com.example.exception;

import org.springframework.http.HttpStatus;

public class DuplicateAccountException extends CustomException{

    public DuplicateAccountException(String message) {
        super(message);
        this.status = HttpStatus.CONFLICT;
    }

}
