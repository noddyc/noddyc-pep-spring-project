package com.example.exception;

public class ClientErrorException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}
