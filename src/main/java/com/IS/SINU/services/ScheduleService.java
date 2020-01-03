package com.IS.SINU.services;

import com.IS.SINU.entities.dao.ScheduleEntry;
import com.IS.SINU.entities.dto.Request;

import java.util.List;

public interface ScheduleService {
    List<ScheduleEntry> getGroupSchedule(Long groupId);
    List<ScheduleEntry> getTeacherSchedule(Request request);
    List<ScheduleEntry> getTeacherSchedule(String username);
}
