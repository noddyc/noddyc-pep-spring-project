package com.example.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception representing a unauthorized error (HTTP 401).
 */
public class UnauthorizedException extends CustomException{

    public UnauthorizedException(String message){
        super(message);
        this.status = HttpStatus.UNAUTHORIZED;
    }
    
}
