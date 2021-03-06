package com.IS.SINU.controllers;

import com.IS.SINU.entities.AuthenticationRequest;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.exceptions.UserNotActivatedException;
import com.IS.SINU.repositories.UserRepository;
import com.IS.SINU.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @GetMapping("/authenticate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void authenticate() {
        // we don't have to do anything here
        // this is just a secure endpoint and the JWTFilter
        // validates the token
        // this service is called at startup of the app to check
        // if the jwt token is still valid
    }

    @PostMapping("/login")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data){
        try {
            String username = data.getUsername();
            User user = this.users.findByUsername(username);
            String role = user.getRole().toString();

            if(!user.getActivated()) {
                throw new UserNotActivatedException(user.getUsername());
            }

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));

            String token = jwtTokenProvider.createToken(username, role);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", user.getUsername());
            model.put("role", user.getRole());
            model.put("token", token);

            return ResponseEntity.ok(model);
        } catch (UserNotActivatedException e) {//need better exception handling
            throw e;
        }
        catch (Exception e){
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }
}
