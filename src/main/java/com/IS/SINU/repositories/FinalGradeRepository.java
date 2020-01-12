package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.FinalGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinalGradeRepository extends JpaRepository<FinalGrade, Long> {

    @Query("from FinalGrade F where F.student.username = ?1")
    List<FinalGrade> listAll(String student);

    @Query("select avg(F.grade) from FinalGrade F where F.student.username = ?1 and (?2 is null or F.subject.year = ?2) and F.subject.semester = ?3")
    Float getAvg(String student, Integer year, String semester);
}
