package com.example.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    protected HttpStatus status = HttpStatus.BAD_REQUEST;

    public CustomException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
