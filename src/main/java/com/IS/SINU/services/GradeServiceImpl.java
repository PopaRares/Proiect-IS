package com.IS.SINU.services;

import com.IS.SINU.entities.CurrentUser;
import com.IS.SINU.entities.dao.Grade;
import com.IS.SINU.entities.dao.Teaching;
import com.IS.SINU.entities.dto.GradeDto;
import com.IS.SINU.entities.enums.Role;
import com.IS.SINU.exceptions.NoAvailableGradesException;
import com.IS.SINU.repositories.GradeRepository;
import com.IS.SINU.repositories.TeachingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository repository;

    @Autowired
    private TeachingRepository teachingRepository;

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

    @Override
    public Grade giveGrade(GradeDto gradeDto) {
        if(gradeDto.getDate() == null) gradeDto.setDate(new Date());
        if(gradeDto.getGrade() > 10) {
            //unauthorised
        }
        if(CurrentUser.role != Role.PROFESSOR) {
            //unauthorised
        }
        Teaching teaching = teachingRepository.getTeaching(CurrentUser.username, gradeDto.getClassId());
        if(teaching == null) {
            //unauthorised
        }
        System.out.println(teaching);
        Grade G = new Grade(teaching, gradeDto);
        repository.save(G);
        return G;
    }


}
