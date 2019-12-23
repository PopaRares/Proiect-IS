package com.IS.SINU.exceptions;

import lombok.Data;

@Data
public class InvalidTokenException extends SINU_Exception {

    public InvalidTokenException() {
        message = "Activation token is invalid!";
    }
}
