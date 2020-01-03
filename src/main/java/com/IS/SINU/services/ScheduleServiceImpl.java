package com.IS.SINU.services;

import com.IS.SINU.entities.dao.ScheduleEntry;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.entities.dto.Request;
import com.IS.SINU.entities.enums.Role;
import com.IS.SINU.exceptions.InvalidGroupIdException;
import com.IS.SINU.exceptions.UserIsNotATeacherException;
import com.IS.SINU.repositories.ScheduleRepository;
import com.IS.SINU.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ScheduleEntry> getGroupSchedule(Long groupId) {
        List<ScheduleEntry> timetable = repository.findByGroup(groupId);
        if(timetable.isEmpty() || timetable.get(0) == null) {
            throw new InvalidGroupIdException(groupId);
        }
        return timetable;
    }

    @Override
    public List<ScheduleEntry> getTeacherSchedule(Request request) {
        if(request.getRole().equalsIgnoreCase(Role.PROFESSOR.toString())) {
            return repository.findByTeacher(request.getUsername());
        } else {
            throw new UserIsNotATeacherException(request.getUsername());
        }
    }

    @Override
    public List<ScheduleEntry> getTeacherSchedule(String username) {
        User teacher = userRepository.findByUsername(username);
        if(teacher.getRole().equals(Role.PROFESSOR.toString())) {
            return repository.findByTeacher(username);
        } else {
            throw new UserIsNotATeacherException(username);
        }
    }
}
