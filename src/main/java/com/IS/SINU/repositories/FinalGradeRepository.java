package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.FinalGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinalGradeRepository extends JpaRepository<FinalGrade, Long> {

    @Query("from FinalGrade F where F.student.username = ?1")
    List<FinalGrade> listAll(String student);

}
