package com.IS.SINU.exceptions;

import lombok.Data;

@Data
public class UserIsNotATeacherException extends SINU_Exception {
    private String username;

    public UserIsNotATeacherException(String username) {
        super();
        this.username = username;
        message = "There user: " + username + " is not registered as a PROFESSOR.";
    }
}
