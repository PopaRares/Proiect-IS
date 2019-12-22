package com.IS.SINU.exceptions;

import java.time.ZonedDateTime;

public abstract class SINU_Exception extends RuntimeException {
    String message;
    ZonedDateTime timestamp;
}
