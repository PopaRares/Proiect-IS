package com.IS.SINU.exceptions;

import lombok.Data;

@Data
public class GradeNotInRangeException extends SINU_Exception {
    private Float grade;

    public GradeNotInRangeException(Float grade) {
        super();
        this.grade = grade;
        message = "Grade " + grade + " is not in range [0, 10].";
    }
}
