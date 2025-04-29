package com.example.exception;

import org.springframework.http.HttpStatus;


/**
 * Base class for application-specific exceptions with default HttpStatus.BAD_REQUEST (400)
 */
public class CustomException extends RuntimeException {

    protected HttpStatus status = HttpStatus.BAD_REQUEST;

    public CustomException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
