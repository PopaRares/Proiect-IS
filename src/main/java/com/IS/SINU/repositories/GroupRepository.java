package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("from Group G where G.id = (select U.groupID from User U where U.username = ?1)")
    Group findByUsername(String username);
}
