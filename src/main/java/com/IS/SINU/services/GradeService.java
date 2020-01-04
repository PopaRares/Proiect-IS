package com.IS.SINU.services;

import com.IS.SINU.entities.dao.Grade;
import com.IS.SINU.entities.dto.GradeRequest;

import java.util.List;

public interface GradeService {
    List<Grade> getGrades(String username);
    List<Grade> getGrades(GradeRequest request);
}
