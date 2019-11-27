package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
