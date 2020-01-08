package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.Teaching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("from Group G where G.id = (select U.groupID from User U where U.username = ?1)")
    Group findByUsername(String username);

    @Query("select S.scheduleId.group from ScheduleEntry S where S.scheduleId.teaching = ?1")
    List<Group> findByTeaching(Teaching teaching);

}
