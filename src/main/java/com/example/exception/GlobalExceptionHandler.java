package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.entity.Account;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Account> handleResourceNotFound(Exception ex){
        System.out.println("handled by ControllerAdvice");
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
}
