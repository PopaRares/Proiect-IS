package com.IS.SINU.Repositories;

import com.IS.SINU.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
