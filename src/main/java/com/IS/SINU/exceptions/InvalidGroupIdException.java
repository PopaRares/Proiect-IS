package com.IS.SINU.exceptions;

import lombok.Data;

@Data
public class InvalidGroupIdException extends SINU_Exception {
    private Long id;

    public InvalidGroupIdException(Long id) {
        super();
        this.id = id;
        message = "There exists no group with ID = " + id;
    }
}
