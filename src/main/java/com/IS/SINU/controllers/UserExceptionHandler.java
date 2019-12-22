package com.IS.SINU.controllers;

import com.IS.SINU.exceptions.EmailExistsException;
import com.IS.SINU.exceptions.ExceptionContainer;
import com.IS.SINU.exceptions.SINU_Exception;
import com.IS.SINU.exceptions.UsernameExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;


@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler({SINU_Exception.class})
    public ResponseEntity<Object> handleExistingFieldException(SINU_Exception e) {
        String errorName = e.getClass().getSimpleName();
        String cause = "";

        //need to think of a better solution to this
        if(errorName.equals("EmailExistsException")) {
            cause = ((EmailExistsException)e).getEmail();
        }
        if(errorName.equals("UsernameExistsException")) {
            cause = ((UsernameExistsException)e).getUsername();
        }

        ExceptionContainer exception = new ExceptionContainer(errorName, e, Collections.singletonList(cause));
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

}
