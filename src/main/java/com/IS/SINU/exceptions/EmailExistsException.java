package com.IS.SINU.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class EmailExistsException extends SINU_Exception {
    private ZonedDateTime timestamp;
    private String email;

    public EmailExistsException(String email) {
        this.email = email;
        message = "There already is an account with that email adress: "  + email;
        timestamp = ZonedDateTime.now();
    }
}
