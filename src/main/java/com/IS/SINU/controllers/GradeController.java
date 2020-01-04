package com.IS.SINU.controllers;

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

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable String username) {
        List<Grade> grades = service.getGrades(username);
        return ResponseEntity.ok(grades);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable String username, @RequestBody GradeRequest request) {
        request.setUsername(username);
        List<Grade> grades = service.getGrades(request);
        return ResponseEntity.ok(grades);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Grade>> getStudentGrades(@RequestBody GradeRequest request) {
        List<Grade> grades = service.getGrades(request);
        return ResponseEntity.ok(grades);
    }
}
