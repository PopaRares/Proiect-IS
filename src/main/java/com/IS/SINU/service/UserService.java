package com.IS.SINU.service;

import com.IS.SINU.Entities.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
