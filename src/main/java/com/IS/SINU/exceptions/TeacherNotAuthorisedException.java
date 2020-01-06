package com.IS.SINU.exceptions;

import lombok.Data;

@Data
public class TeacherNotAuthorisedException extends SINU_Exception {
    private String studentFirstName;
    private String studentLastName;

    public TeacherNotAuthorisedException(String studentFirstName, String studentLastName) {
        super();
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        message = "You are not the teacher of " + studentFirstName + " " + studentLastName;
    }
}