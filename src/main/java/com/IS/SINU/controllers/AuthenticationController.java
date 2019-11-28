package com.IS.SINU.controllers;

import com.IS.SINU.entities.AuthenticationRequest;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.repositories.UserRepository;
//import com.IS.SINU.Repositories.UserRepositoryImpl;
import com.IS.SINU.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @RequestMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data){
        try {
            String username = data.getUsername();
            User user = this.users.findByUsername(username);
            String role = user.getRole();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));

            String token = jwtTokenProvider.createToken(username, role);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("role", role);
            model.put("token", token);

            return ok(model);
        } catch (Exception e){
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }
}
