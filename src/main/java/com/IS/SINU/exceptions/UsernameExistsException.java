package com.IS.SINU.exceptions;

import lombok.Data;


@Data
public class UsernameExistsException extends SINU_Exception {
    private String username;

    public UsernameExistsException(String username) {
        super();
        this.username = username;
        message = "There already is an account with that username: "  + username;
    }
}
