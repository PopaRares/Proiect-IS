package com.IS.SINU.service;

import com.IS.SINU.Entities.User;
import com.IS.SINU.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
