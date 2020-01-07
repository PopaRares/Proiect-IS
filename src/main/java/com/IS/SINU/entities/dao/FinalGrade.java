package com.IS.SINU.entities.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "final_grades")
@Data
public class FinalGrade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "grade")
    private Float grade;

    @Column(name = "grade_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private User student;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "student_id")
    private Long studentId;

}
