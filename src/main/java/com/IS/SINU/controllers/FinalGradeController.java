package com.IS.SINU.controllers;

import com.IS.SINU.entities.dao.FinalGrade;
import com.IS.SINU.entities.dao.Subject;
import com.IS.SINU.services.FinalGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Float>> getFinal(@RequestParam(required = false) String semester, @RequestParam Integer year) {
        System.out.println("lol");
        return null;
    }
}
