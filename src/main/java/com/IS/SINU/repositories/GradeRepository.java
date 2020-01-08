package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.Grade;
import com.IS.SINU.entities.dao.Subject;
import com.IS.SINU.entities.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query("from Grade G where G.student.username = ?1 and (?2 is null or G.teaching.class_name.subject.name = ?2) and (?3 is null or G.teaching.class_name.type = ?3) and (?4 is null or G.teaching.class_name.subject.year = ?4) and (?5 is null or G.teaching.class_name.subject.semester = ?5) order by G.date")
    List<Grade> findDescriptive(String username, String subjectName, String classType, Integer year, String semester);

    @Query("from Grade G where G.teaching.professor.username = ?1 order by G.date, G.student.lastName, G.student.firstName")
    List<Grade> findByTeacher(String username);

    @Query("select avg(G.grade) from Grade G where G.teaching.class_name.subject = ?1 and G.teaching.class_name.type = ?2 and G.student = ?3")
    Float getAvg(Subject subject, String type, User student);

}
