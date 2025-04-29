package com.example.exception;

import org.springframework.http.HttpStatus;

public class ClientErrorException extends CustomException {

    public ClientErrorException(String message) {
        super(message);
    }
}
