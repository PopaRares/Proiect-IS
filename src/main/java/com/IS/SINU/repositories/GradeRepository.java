package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query("from Grade G where G.student.username = ?1")
    List<Grade> findByUsername(String username);

    @Query("from Grade G where G.student.username = ?1 and G.teaching.class_name.subject.name = ?2")
    List<Grade> findBySubject(String username, String subjectName);

    @Query("from Grade G where G.student.username = ?1 and G.teaching.class_name.subject.name = ?2 and G.teaching.class_name.type = ?3")
    List<Grade> findByClassType(String username, String subjectName, String classType);
}
