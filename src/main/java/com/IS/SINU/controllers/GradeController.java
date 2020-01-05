package com.IS.SINU.controllers;

import com.IS.SINU.entities.CurrentUser;
import com.IS.SINU.entities.dao.Grade;
import com.IS.SINU.entities.dto.GradeRequest;
import com.IS.SINU.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grades")
public class GradeController {

    @Autowired
    private GradeService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Grade>> getStudentGrades(@RequestParam(required = false) String subject,
                                                        @RequestParam(required = false) String type,
                                                        @RequestParam(required = false) Integer year,
                                                        @RequestParam(required = false) String semester) {
        List<Grade> grades = service.getGrades(subject, type, year, semester);
        return ResponseEntity.ok(grades);
    }
}
