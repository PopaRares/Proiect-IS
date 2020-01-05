package com.IS.SINU.services;

import com.IS.SINU.entities.CurrentUser;
import com.IS.SINU.entities.dao.Grade;
import com.IS.SINU.entities.dto.GradeRequest;
import com.IS.SINU.entities.enums.Role;
import com.IS.SINU.entities.enums.Semester;
import com.IS.SINU.exceptions.NoAvailableGradesException;
import com.IS.SINU.exceptions.NonexistentUserException;
import com.IS.SINU.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository repository;

    @Override
    public List<Grade> getGrades(String subject, String type, Integer year, String semester) {
        List<Grade> grades = null;
        if(CurrentUser.role == Role.STUDENT) {
            if(semester != null) {
                semester = semester.toUpperCase();
            }
            grades = repository.findDescriptive(CurrentUser.username, subject, type, year, semester);
        }
        if(CurrentUser.role == Role.PROFESSOR) {
            grades = repository.findByTeacher(CurrentUser.username);
        }
        if(grades.isEmpty()) {
            throw new NoAvailableGradesException(subject, type, year, semester);
        }
        return grades;
    }
}
