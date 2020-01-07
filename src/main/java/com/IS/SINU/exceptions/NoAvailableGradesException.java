package com.IS.SINU.exceptions;

import lombok.Data;

@Data
public class NoAvailableGradesException extends SINU_Exception {
    private String subject;
    private String type;
    private Integer year;
    private String semester;

    public NoAvailableGradesException(String subject, String type, Integer year, String semester) {
        super();
        this.subject = subject;
        this.type = type;
        this.year = year;
        this.semester = semester;

        this.message = "There are no grades to display using this query.";
    }
}
