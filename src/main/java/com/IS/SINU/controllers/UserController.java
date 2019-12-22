package com.IS.SINU.controllers;

import com.IS.SINU.entities.dao.User;
import com.IS.SINU.entities.dto.UserDto;
import com.IS.SINU.exceptions.EmailExistsException;
import com.IS.SINU.security.activation.ActivationToken;
import com.IS.SINU.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import javax.validation.Valid;



@RestController
@RequestMapping("/user")
public class UserController {//in progress

    @Autowired
    private UserService service;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<User> registerUserAccount (@Valid @RequestBody UserDto regUser) throws EmailExistsException {
        User user = service.registerNewUserAccount(regUser);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/activate", method = RequestMethod.POST)
    public ResponseEntity<String> activateAccount(@RequestParam String token) {
        ActivationToken.verifyToken(token);
        return ResponseEntity.ok("Penis");
    }

}
