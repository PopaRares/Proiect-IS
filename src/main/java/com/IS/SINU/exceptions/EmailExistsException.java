package com.IS.SINU.exceptions;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class EmailExistsException extends SINU_Exception {
    private ZonedDateTime timestamp;
    private String email;

    public EmailExistsException(String email) {
        super();
        this.email = email;
        message = "There already is an account with that email adress: "  + email;
    }
}
