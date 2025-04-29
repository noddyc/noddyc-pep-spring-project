package com.example.exception;

/**
 * Exception representing a client-side error (HTTP 400).
 */
public class ClientErrorException extends CustomException {

    public ClientErrorException(String message) {
        super(message);
    }
    
}
