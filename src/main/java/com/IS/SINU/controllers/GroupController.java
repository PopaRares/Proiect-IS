package com.IS.SINU.controllers;

import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.entities.dto.Request;
import com.IS.SINU.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> getGroup(@RequestBody Request request) {
        Group group = service.getGroupByUsername(request.getUsername());
        return ResponseEntity.ok(group);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> getGroup(@PathVariable Long id) {
        Group group = service.getGroupById(id);
        return ResponseEntity.ok(group);
    }
}
