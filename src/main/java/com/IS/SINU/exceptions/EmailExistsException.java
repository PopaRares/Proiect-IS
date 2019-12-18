package com.IS.SINU.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class EmailExistsException extends RuntimeException {
    private String message;
    private String email;
    private ZonedDateTime timestamp;

    public EmailExistsException(String email) {
        this.email = email;
        message = "There is an account with that email adress: "  + email;
        timestamp = ZonedDateTime.now();
    }
}
