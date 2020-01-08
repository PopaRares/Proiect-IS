package com.IS.SINU.exceptions;

import com.IS.SINU.entities.enums.Role;
import lombok.Data;

@Data
public class NonexistentUserException extends SINU_Exception {
    private String username;

    public NonexistentUserException(String username, String role) {
        super();
        this.username = username;
        message = "There exists no " + role + " with the following username: " + username;
    }
}
