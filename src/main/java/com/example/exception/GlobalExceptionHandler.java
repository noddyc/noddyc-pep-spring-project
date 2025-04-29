package com.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handler for client error 
     * @param ex
     * @return ResponseEntity
     * */
    @ExceptionHandler(ClientErrorException.class)
    public ResponseEntity<Void> handleClientError(ClientErrorException ex){
        return ResponseEntity.status(ex.getStatus()).body(null);
    }

    /**
     * Handler for duplicate account
     * @param ex
     * @return ResponseEntity
     * */
    @ExceptionHandler(DuplicateAccountException.class)
    public ResponseEntity<Void> handleDuplicateAccountError(DuplicateAccountException ex){
        return ResponseEntity.status(ex.getStatus()).body(null);
    }

    /**
     * Handler for unauthorization
     * @param ex
     * @return ResponseEntity
     * */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Void> handleUnauthorizedError(UnauthorizedException ex){
        return ResponseEntity.status(ex.getStatus()).body(null);
    }    
}
