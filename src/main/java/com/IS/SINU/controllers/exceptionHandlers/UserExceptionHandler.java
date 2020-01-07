package com.IS.SINU.controllers.exceptionHandlers;

import com.IS.SINU.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;


@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler({EmailExistsException.class, UsernameExistsException.class})
    public ResponseEntity<ExceptionContainer> handleExistingFieldException(SINU_Exception e) {
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

    @ExceptionHandler({UserNotActivatedException.class})
    public ResponseEntity<ExceptionContainer> handleUserNotActivatedException(UserNotActivatedException e) {
        ExceptionContainer exception = new ExceptionContainer(e.getClass().getSimpleName(), e, Collections.singletonList(e.getUsername()));
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidTokenException.class, ExpiredTokenException.class})
    public ResponseEntity<ExceptionContainer> handleTokenExceptions(SINU_Exception e) {
        ExceptionContainer exception = new ExceptionContainer(e.getClass().getSimpleName(), e, null);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NonexistentUserException.class})
    public ResponseEntity<ExceptionContainer> handleNoUserException(NonexistentUserException e) {
        ExceptionContainer exception = new ExceptionContainer(e.getClass().getSimpleName(), e, Collections.singletonList(e.getUsername()));
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserIsNotRightRoleException.class})
    public ResponseEntity<ExceptionContainer> handleUserIsNotTeacherException(UserIsNotRightRoleException e) {
        ExceptionContainer exception = new ExceptionContainer(e.getClass().getSimpleName(), e, Collections.singletonList(e.getUsername()));
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

}
