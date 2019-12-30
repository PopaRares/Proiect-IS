package com.IS.SINU.controllers.exceptionHandlers;

import com.IS.SINU.exceptions.ExceptionContainer;
import com.IS.SINU.exceptions.InvalidGroupIdException;
import com.IS.SINU.exceptions.SINU_Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class GroupExceptionHandler {

    @ExceptionHandler({InvalidGroupIdException.class})
    public ResponseEntity<ExceptionContainer> handleInvalidGroupIdException(InvalidGroupIdException e) {
        String errorName = e.getClass().getSimpleName();
        ExceptionContainer exception = new ExceptionContainer(errorName, e, Collections.singletonList(e.getId()));
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
