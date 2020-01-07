package com.IS.SINU.services;

import com.IS.SINU.entities.dao.FinalGrade;
import com.IS.SINU.entities.dao.Subject;
import com.IS.SINU.entities.enums.Semester;

import java.util.List;

public interface FinalGradeService {

    List<FinalGrade> listAll();
    FinalGrade calculateFinalGrade(Subject subject);
    Float calculateSemesterAvg(Integer year, Semester semester);
    Float calculateYearAvg(Integer year);
}
