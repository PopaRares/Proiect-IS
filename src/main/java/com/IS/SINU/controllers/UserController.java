package com.IS.SINU.controllers;

import com.IS.SINU.entities.dao.User;
import com.IS.SINU.entities.dto.UserDto;
import com.IS.SINU.exceptions.EmailExistsException;
import com.IS.SINU.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {//in progress

    @Autowired
    private UserService service;

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> registerUserAccount (@Valid @RequestBody UserDto regUser) throws EmailExistsException {
        service.registerNewUserAccount(regUser);
        return ResponseEntity.ok(Collections.singletonMap("response", "Account registered. Check your email!"));
    }

    @RequestMapping(value = "/activate/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> activateAccount(@PathVariable String token) {
        System.out.println(token);
        User user = service.activateAccount(token);
        return ResponseEntity.ok(user);
    }

}
