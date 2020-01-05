package com.IS.SINU.services;

import com.IS.SINU.entities.CurrentUser;
import com.IS.SINU.entities.dao.Grade;
import com.IS.SINU.entities.dto.GradeRequest;
import com.IS.SINU.entities.enums.Role;
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
    public List<Grade> getGrades() {
        List<Grade> grades = null;
        if(CurrentUser.role == Role.STUDENT) {
            System.out.println(CurrentUser.username);
            grades = repository.findByUsername(CurrentUser.username);
        }
        if(CurrentUser.role == Role.PROFESSOR) {
            grades = repository.findByTeacher(CurrentUser.username);
        }
        return grades;
    }

    @Override
    public List<Grade> getGrades(GradeRequest request) {
        List<Grade> grades = null;
        if(!request.getType().isEmpty()) {
            grades = repository.findByClassType(request.getUsername(), request.getSubject(), request.getType());
        } else if(!request.getSubject().isEmpty()) {
            grades = repository.findBySubject(request.getUsername(), request.getSubject());
        }
        if(grades == null || grades.isEmpty()) {
            throw new NonexistentUserException(request.getUsername());
        } else {
            return grades;
        }
    }
}
