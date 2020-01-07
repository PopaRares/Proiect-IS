package com.IS.SINU.services;

import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.ScheduleEntry;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.entities.dto.Request;
import com.IS.SINU.entities.enums.Role;
import com.IS.SINU.exceptions.InvalidGroupIdException;
import com.IS.SINU.exceptions.NonexistentUserException;
import com.IS.SINU.exceptions.UserIsNotRightRoleException;
import com.IS.SINU.repositories.GroupRepository;
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

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<ScheduleEntry> getGroupSchedule(Long groupId) {
        List<ScheduleEntry> timetable = repository.findByGroupId(groupId);
        if(timetable.isEmpty() || timetable.get(0) == null) {
            throw new InvalidGroupIdException(groupId);
        }
        return timetable;
    }

    @Override
    public List<ScheduleEntry> getTeacherSchedule(Request request) {
        if(request.getRole().equalsIgnoreCase(Role.PROFESSOR.toString())) {
            List<ScheduleEntry> timetable = repository.findByTeacher(request.getUsername());
            if(timetable.isEmpty() || timetable.get(0) == null) {
                throw new UserIsNotRightRoleException(request.getUsername());
            } else {
                return timetable;
            }
        } else {
            throw new UserIsNotRightRoleException(request.getUsername());
        }
    }

    @Override
    public List<ScheduleEntry> getTeacherSchedule(String username) {
        User teacher = userRepository.findByUsername(username);
        if(teacher != null && teacher.getRole().equals(Role.PROFESSOR.toString())) {
            return repository.findByTeacher(username);
        } else {
            throw new UserIsNotRightRoleException(username);
        }
    }

    @Override
    public List<ScheduleEntry> getStudentSchedule(Request request) {
        if(request.getRole().equalsIgnoreCase(Role.STUDENT.toString())) {
            Group group = groupRepository.findByUsername(request.getUsername());
            List<ScheduleEntry> timetable = repository.findByGroupId(group.getId());
            if(timetable.isEmpty() || timetable.get(0) == null) {
                throw new NonexistentUserException(request.getUsername());
            } else {
                return timetable;
            }
        } else {
            throw new NonexistentUserException(request.getUsername());
        }
    }

    @Override
    public List<ScheduleEntry> getStudentSchedule(String username) {
        User student = userRepository.findByUsername(username);
        Group group = groupRepository.findByUsername(username);
        if(student != null && student.getRole().equals(Role.STUDENT.toString())) {
            return repository.findByGroupId(group.getId());
        } else {
            throw new NonexistentUserException(username);
        }
    }
}
