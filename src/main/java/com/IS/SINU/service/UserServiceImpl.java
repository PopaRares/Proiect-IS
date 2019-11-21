package com.IS.SINU.service;

import com.IS.SINU.Entities.User;
import com.IS.SINU.Repositories.UserRepository;
import com.IS.SINU.Repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    private UserRepositoryImpl ur = new UserRepositoryImpl();

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        ur.insert(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
