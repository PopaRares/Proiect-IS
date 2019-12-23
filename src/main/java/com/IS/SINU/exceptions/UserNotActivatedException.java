package com.IS.SINU.exceptions;

import lombok.Data;


@Data
public class UserNotActivatedException extends SINU_Exception {
    private String username;

    public UserNotActivatedException(String username) {
        super();
        this.username = username;
        message = "Your user account has ot yet been activated: " + username;
    }
}
