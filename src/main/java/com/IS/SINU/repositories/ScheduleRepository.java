package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.ScheduleIdentity;
import com.IS.SINU.entities.dao.ScheduleEntry;
import com.IS.SINU.entities.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntry, ScheduleIdentity> {
    @Query("from ScheduleEntry S where S.scheduleId.group.id = ?1")
    List<ScheduleEntry> findByGroupId(Long id);

    @Query("from ScheduleEntry S where S.scheduleId.teaching.professor.username = ?1")
    List<ScheduleEntry> findByTeacher(String username);

//    @Query(value = "insert into schedule(teaching_id, `group`, day, `time`, parity, location) values(?1, 10, 'THURSDAY', '08:00:00', 'BOTH', 'Pe Barițiu acolo în stânga, înainte de scări')", nativeQuery = true)
//    void makeTufisiOurTeacher(Long tufisiTeachId);
}
