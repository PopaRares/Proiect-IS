package com.IS.SINU.controllers;

import com.IS.SINU.Resource.Test;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public Test test(@RequestParam(value="name", defaultValue="World") String name, @RequestParam(value="grade", defaultValue="5") int grade) {
        return new Test(name, grade);
    }

}
