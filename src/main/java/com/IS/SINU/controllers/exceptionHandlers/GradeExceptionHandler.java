package com.IS.SINU.controllers.exceptionHandlers;

import com.IS.SINU.exceptions.ExceptionContainer;
import com.IS.SINU.exceptions.NoAvailableGradesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class GradeExceptionHandler {

    @ExceptionHandler({NoAvailableGradesException.class})
    public ResponseEntity<ExceptionContainer> handleInvalidGroupIdException(NoAvailableGradesException e) {
        ArrayList<Object> causes = new ArrayList<>();
        if(e.getSubject() != null) causes.add(e.getSubject());
        if(e.getType() != null) causes.add(e.getType());
        if(e.getYear() != null) causes.add(e.getYear());
        if(e.getSemester() != null) causes.add(e.getSemester());
        ExceptionContainer exception = new ExceptionContainer(e.getClass().getSimpleName(), e, causes);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
