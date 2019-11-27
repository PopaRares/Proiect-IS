package com.IS.SINU.controllers;

import com.IS.SINU.entities.dao.User;
import com.IS.SINU.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private UserRepository repo;

    @RequestMapping("/test")
    public Optional<User> getUser(@RequestParam(value="id", defaultValue = "1") Long id) {
        return repo.findById(id);
    }
}
