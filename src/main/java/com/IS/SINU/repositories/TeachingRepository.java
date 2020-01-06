package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.Teaching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeachingRepository extends JpaRepository<Teaching, Long> {

    @Query("from Teaching T where T.professor.username = ?1 and T.class_name.id = ?2")
    Teaching getTeaching(String professor_username, Long classId);
}
