package com.IS.SINU.controllers;

import com.IS.SINU.entities.CurrentUser;
import com.IS.SINU.entities.dao.ClassGroup;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.entities.dto.UserDto;
import com.IS.SINU.entities.enums.Role;
import com.IS.SINU.exceptions.EmailExistsException;
import com.IS.SINU.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {//in progress

    @Autowired
    private UserService service;

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Object, Object>> registerUserAccount(@Valid @RequestBody UserDto regUser) throws EmailExistsException {
        service.registerNewUserAccount(regUser);
        return ResponseEntity.ok(Collections.singletonMap("response", "Account registered. Check your email!"));
    }

    @RequestMapping(value = "/activate/{token}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> activateAccount(@PathVariable String token) {
        System.out.println(token);
        User user = service.activateAccount(token);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> getUserDetails(@PathVariable String username) {
        HashMap<String, Object> retMap = new HashMap<>();

        User user = service.getUser(username);
        if(user.getRole() == Role.PROFESSOR) {
            retMap.put("professor", user);
            retMap.put("teach_list", service.getTeachingList(user.getId()));
        } else {
            retMap.put("student", user);
        }
        return ResponseEntity.ok(retMap);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> getUserDetails() {
        HashMap<String, Object> retMap = new HashMap<>();

        User user = service.getUser(CurrentUser.username);
        if(user.getRole() == Role.PROFESSOR) {
            retMap.put("professor", user);
            retMap.put("teach_list", service.getTeachingList(user.getId()));
        } else {
            retMap.put("student", user);
        }
        return ResponseEntity.ok(retMap);
    }
}
