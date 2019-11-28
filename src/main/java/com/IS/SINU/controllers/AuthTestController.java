package com.IS.SINU.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthTestController {
    @RequestMapping("/authenticated")
    public String authRoute() {
        try {
            return "You can see this because you are authenticated.";
        } catch (Exception e){
            return "UNAUTHORIZED";
        }
    }
}
