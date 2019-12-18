package com.IS.SINU.controllers;

import com.IS.SINU.exceptions.EmailExistsException;
import com.IS.SINU.exceptions.ExceptionContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;


@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value={EmailExistsException.class})
    public ResponseEntity<Object> handleExistingEmailException (EmailExistsException e) {
        ExceptionContainer exception = new ExceptionContainer(e.getClass().getSimpleName(), e.getMessage(), Collections.singletonList(e.getEmail()), e.getTimestamp());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

}
