package com.IS.SINU.controllers;

import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.ScheduleEntry;
import com.IS.SINU.entities.dto.Request;
import com.IS.SINU.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScheduleEntry>> getGroupSchedule(@PathVariable Long id) {
        List<ScheduleEntry> timetable = service.getGroupSchedule(id);
        return ResponseEntity.ok(timetable);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScheduleEntry>> getGroupSchedule(@RequestBody Group group) {
        List<ScheduleEntry> timetable = service.getGroupSchedule(group.getId());
        return ResponseEntity.ok(timetable);
    }

    @RequestMapping(value = "teacher/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScheduleEntry>> getTeacherSchedule(@PathVariable String username) {
        List<ScheduleEntry> timetable = service.getTeacherSchedule(username);
        return ResponseEntity.ok(timetable);
    }

    @RequestMapping(value = "teacher", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScheduleEntry>> getTeacherSchedule(@RequestBody Request request) {
        List<ScheduleEntry> timetable = service.getTeacherSchedule(request);
        return ResponseEntity.ok(timetable);
    }

    @RequestMapping(value = "student/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScheduleEntry>> getStudentSchedule(@PathVariable String username) {
        List<ScheduleEntry> timetable = service.getStudentSchedule(username);
        return ResponseEntity.ok(timetable);
    }

    @RequestMapping(value = "student", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScheduleEntry>> getStudentSchedule(@RequestBody Request request) {
        List<ScheduleEntry> timetable = service.getStudentSchedule(request);
        return ResponseEntity.ok(timetable);
    }
}
