package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByActivationToken(String activationToken);

    @Transactional
    @Modifying
    @Query("update User u set u.activated = true where u.id = ?1")
    void activateUser(long id);
}
