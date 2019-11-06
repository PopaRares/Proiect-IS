package com.IS.SINU.controllers;

import com.IS.SINU.Entities.User;
import com.IS.SINU.Repositories.UserRepository;
//import com.IS.SINU.Repositories.UserRepositoryImpl;
import com.IS.SINU.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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

    @RequestMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data){
       try {
           BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
           String username = data.getUsername();
           System.out.println(username + "--------------AuthController");
           System.out.println(this.users.findByUsername(username));
           //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
           String token = jwtTokenProvider.createToken(username, this.users.findByUsername(username).getRoles());

           Map<Object, Object> model = new HashMap<>();
           model.put("username", username);
           model.put("token", token);

           return ok(token);
       } catch (Exception e) {
           e.printStackTrace();

           return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
       }
    }
}
