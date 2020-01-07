package com.IS.SINU.services;

import com.IS.SINU.entities.CurrentUser;
import com.IS.SINU.entities.dao.FinalGrade;
import com.IS.SINU.entities.dao.Subject;
import com.IS.SINU.entities.enums.Role;
import com.IS.SINU.entities.enums.Semester;
import com.IS.SINU.exceptions.UserIsNotRightRoleException;
import com.IS.SINU.repositories.FinalGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalGradeServiceImpl implements FinalGradeService {
    @Autowired
    private FinalGradeRepository repository;

    @Override
    public List<FinalGrade> listAll() {
        if(CurrentUser.role != Role.STUDENT) {
            throw new UserIsNotRightRoleException(CurrentUser.username, Role.STUDENT);
        }
        return repository.listAll(CurrentUser.username);
    }

    @Override
    public FinalGrade calculateFinalGrade(Subject subject) {
        return null;
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
