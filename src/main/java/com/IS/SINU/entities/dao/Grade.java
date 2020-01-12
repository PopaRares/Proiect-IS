package com.IS.SINU.entities.dao;

import com.IS.SINU.entities.dto.GradeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grades")
@Data
@NoArgsConstructor
public class Grade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @JsonIgnore
    private Long id;

    @Column(name = "grade")
    private Float grade;

    @Column(name = "grade_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "teaching_id", insertable = false, updatable = false)
    private Teaching teaching;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private User student;

    @JsonIgnore
    @Column(name = "teaching_id")
    private Long teachingId;

    @JsonIgnore
    @Column(name = "student_id")
    private Long studentId;

    public Grade(Teaching teaching, GradeDto gradeDto, User student) {
        this.teachingId = teaching.getId();
        this.grade = gradeDto.getGrade();
        this.date = gradeDto.getDate();
        this.studentId = student.getId();

        this.teaching = teaching;
        this.student = student;
    }
}
