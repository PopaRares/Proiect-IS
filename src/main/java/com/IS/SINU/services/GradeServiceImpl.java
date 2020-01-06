package com.IS.SINU.services;

import com.IS.SINU.entities.CurrentUser;
import com.IS.SINU.entities.dao.Grade;
import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.Teaching;
import com.IS.SINU.entities.dto.GradeDto;
import com.IS.SINU.entities.enums.Role;
import com.IS.SINU.exceptions.*;
import com.IS.SINU.repositories.GradeRepository;
import com.IS.SINU.repositories.GroupRepository;
import com.IS.SINU.repositories.TeachingRepository;
import com.IS.SINU.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository repository;

    @Autowired
    private TeachingRepository teachingRepository;

    @Autowired
    private GroupRepository groupRepository;

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
        if(gradeDto.getGrade() <= 0 || gradeDto.getGrade() > 10) {
            throw new GradeNotInRangeException(gradeDto.getGrade());
        }
        if(CurrentUser.role != Role.PROFESSOR) {
           throw new UserIsNotATeacherException(CurrentUser.username);
        }
        Teaching teaching = teachingRepository.getTeaching(CurrentUser.username, gradeDto.getClassId());
        if(teaching == null) {
            throw new TeacherNotTeachingClassException();
        }
        Group group = groupRepository.findByTeaching(teaching);
        if(!group.getStudents().contains(gradeDto.getStudent())) {
            throw new TeacherNotAuthorisedException(gradeDto.getStudent().getFirstName(), gradeDto.getStudent().getLastName());
        }
        Grade G = new Grade(teaching, gradeDto);
        repository.save(G);
        return G;
    }


}
