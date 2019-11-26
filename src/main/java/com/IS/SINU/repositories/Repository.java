package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<User, Long> {
}
