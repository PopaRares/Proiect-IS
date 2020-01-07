package com.IS.SINU.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class DateInFutureException extends SINU_Exception {
    private Date date;

    public DateInFutureException(Date date) {
        super();
        this.date = date;
        this.message = "You cannot give a grade in the future! Today's date: " + new Date() + ".";
    }
}
