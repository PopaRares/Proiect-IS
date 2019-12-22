package com.IS.SINU.exceptions;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class UsernameExistsException extends SINU_Exception {
    private String username;

    public UsernameExistsException(String username) {
        this.username = username;
        message = "There already is an account with that username: "  + username;
        timestamp = ZonedDateTime.now();
    }
}
