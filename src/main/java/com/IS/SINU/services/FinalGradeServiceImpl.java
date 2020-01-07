package com.IS.SINU.services;

import com.IS.SINU.entities.CurrentUser;
import com.IS.SINU.entities.dao.FinalGrade;
import com.IS.SINU.entities.dao.Subject;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.entities.enums.Role;
import com.IS.SINU.entities.enums.Semester;
import com.IS.SINU.entities.enums.SubjectType;
import com.IS.SINU.exceptions.UserIsNotRightRoleException;
import com.IS.SINU.repositories.FinalGradeRepository;
import com.IS.SINU.repositories.GradeRepository;
import com.IS.SINU.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinalGradeServiceImpl implements FinalGradeService {
    @Autowired
    private FinalGradeRepository repository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<FinalGrade> listAll() {
        if (CurrentUser.role != Role.STUDENT) {
            throw new UserIsNotRightRoleException(CurrentUser.username, Role.STUDENT);
        }
        return repository.listAll(CurrentUser.username);
    }

    @Override
    public List<FinalGrade> calculateFinalGrade(Subject subject) {
        List<User> studentList = userRepository.findBySubject(subject)
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(studentList);

        return studentList.stream()
                .distinct()
                .map(S -> {
                    FinalGrade grade = new FinalGrade();
                    grade.setDate(new Date());
                    grade.setStudentId(S.getId());
                    grade.setStudent(S);
                    grade.setSubjectId(subject.getId());
                    grade.setSubject(subject);

                    Float courseAvg = gradeRepository.getAvg(subject, SubjectType.COURSE.name(), S);
                    Float labAvg = gradeRepository.getAvg(subject, SubjectType.LABORATORY.name(), S);
                    Float semAvg = gradeRepository.getAvg(subject, SubjectType.SEMINAR.name(), S);

                    float finalValue =  courseAvg * subject.getCourse_weight() +
                                        labAvg * subject.getLab_weight() +
                                        semAvg * subject.getSeminar_weight();
                    grade.setGrade(finalValue/100);

                    return grade;
                }).collect(Collectors.toList());
    }

    @Override
    public Float calculateSemesterAvg(Integer year, Semester semester) {
        return null;
    }

    @Override
    public Float calculateYearAvg(Integer year) {
        return null;
    }
}
