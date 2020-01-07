package com.IS.SINU.controllers;

import com.IS.SINU.entities.dao.FinalGrade;
import com.IS.SINU.entities.dao.Subject;
import com.IS.SINU.services.FinalGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/final_grades")
public class FinalGradeController {

    @Autowired
    private FinalGradeService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FinalGrade>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FinalGrade>> calculateFinalGrade(@RequestBody Subject subject) {
        List<FinalGrade> finalGrades = service.calculateFinalGrade(subject);
        return ResponseEntity.ok(finalGrades);
    }
}
