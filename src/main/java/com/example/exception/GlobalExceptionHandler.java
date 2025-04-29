package com.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientErrorException.class)
    public ResponseEntity<Void> handleClientError(ClientErrorException ex){
        return ResponseEntity.status(ex.getStatus()).body(null);
    }

    @ExceptionHandler(DuplicateAccountException.class)
    public ResponseEntity<Void> handleDuplicateAccountError(DuplicateAccountException ex){
        return ResponseEntity.status(ex.getStatus()).body(null);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Void> handleUnauthorizedError(UnauthorizedException ex){
        return ResponseEntity.status(ex.getStatus()).body(null);
    }
    

    
}
