package com.IS.SINU.services;

import com.IS.SINU.entities.dao.Grade;
import com.IS.SINU.entities.dto.GradeDto;

import java.util.List;

public interface GradeService {
    List<Grade> getGrades(String subject, String type, Integer year, String semester);
    Grade giveGrade(GradeDto gradeDto);
}
