package com.IS.SINU.exceptions;

import com.IS.SINU.entities.enums.SubjectType;
import com.IS.SINU.exceptions.SINU_Exception;
import lombok.Data;
import org.assertj.core.util.diff.Delta;

@Data
public class TeacherNotTeachingClassException extends SINU_Exception {
//    private String subjectName;
//    private SubjectType type;

    public TeacherNotTeachingClassException() {
        super();
        message = "You do not teach this class.";
    }
}
