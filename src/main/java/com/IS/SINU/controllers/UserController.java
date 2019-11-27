package com.IS.SINU.controllers;

import com.IS.SINU.entities.dao.TestObj;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.repositories.UserRepository;
import com.IS.SINU.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/user")
public class UserController {//in progress

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserService service;

    @RequestMapping("/save")
    public ResponseEntity saveUser(@RequestBody User u) {
        System.out.println("Request: ");
        System.out.println(u);
        service.save(u);
        return ok(u);
    }
}
