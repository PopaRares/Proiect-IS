package com.IS.SINU.exceptions;

import lombok.Data;

@Data
public class NonexistentUserException extends SINU_Exception {
    private String username;

    public NonexistentUserException(String username) {
        super();
        this.username = username;
        message = "There exists no user with the following username: " + username;
    }
}
