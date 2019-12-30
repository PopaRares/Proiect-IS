package com.IS.SINU.controllers;

import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> getGroup(@RequestBody User user) {
        Group group = service.getGroup(user);
        System.out.println("IN CONTROLLER");
        System.out.println(group);
        return ResponseEntity.ok(group);
    }
}
