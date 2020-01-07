package com.IS.SINU.controllers.exceptionHandlers;

import com.IS.SINU.exceptions.*;
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
        if (e.getSubject() != null) causes.add(e.getSubject());
        if (e.getType() != null) causes.add(e.getType());
        if (e.getYear() != null) causes.add(e.getYear());
        if (e.getSemester() != null) causes.add(e.getSemester());
        ExceptionContainer exception = new ExceptionContainer(e.getClass().getSimpleName(), e, causes);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({GradeNotInRangeException.class, TeacherNotAuthorisedException.class, TeacherNotTeachingClassException.class, DateInFutureException.class})
    public ResponseEntity<ExceptionContainer> handleInvalidGradeInputs(SINU_Exception e) {
        ArrayList<Object> causes = new ArrayList<>();
        switch (e.getClass().getSimpleName()) {
            case "GradeNotInRangeException":
                causes.add(((GradeNotInRangeException) e).getGrade());
                break;
            case "TeacherNotAuthorisedException":
                causes.add(((TeacherNotAuthorisedException) e).getStudentFirstName());
                causes.add(((TeacherNotAuthorisedException) e).getStudentLastName());
                break;
            case "DateInFutureException":
                causes.add(((DateInFutureException)e).getDate());
        }
        return new ResponseEntity<>(new ExceptionContainer(e.getClass().getSimpleName(), e, causes), HttpStatus.BAD_REQUEST);
    }
}
