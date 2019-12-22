package com.IS.SINU.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ExceptionContainer {
    private String type;
    private String message;
    private List<Object>  causes;
    private ZonedDateTime timestamp;

    public ExceptionContainer(String type, SINU_Exception exception, List<Object> causes) {
        this.type = type;
        this.message = exception.message;
        this.timestamp = exception.timestamp;
        this.causes = causes;
    }
}
