package com.IS.SINU.services;

import com.IS.SINU.entities.dao.Grade;
import com.IS.SINU.entities.dto.GradeRequest;
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
    public List<Grade> getGrades(String username) {//not done
        List<Grade> grades = repository.findByUsername(username);
        if(grades.isEmpty()) {
            throw new NonexistentUserException(username);
        } else {
            return grades;
        }
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
