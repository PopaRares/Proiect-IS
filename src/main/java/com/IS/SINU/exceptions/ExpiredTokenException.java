package com.IS.SINU.exceptions;

import lombok.Data;

@Data
public class ExpiredTokenException extends SINU_Exception {

    public ExpiredTokenException() {
        message = "Activation token is expired!";
    }
}
