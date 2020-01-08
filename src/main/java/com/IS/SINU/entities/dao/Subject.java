package com.IS.SINU.entities.dao;

import com.IS.SINU.entities.enums.Semester;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "subject")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Subject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @JsonIgnore
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private Integer year;

    @Column(name = "semester")
    @Enumerated(EnumType.STRING)
    private Semester semester;

    @Column(name = "credits")
    private Integer credits;

    @Column(name = "course_weight")
    private Integer course_weight;

    @Column(name = "lab_weight")
    private Integer lab_weight;

    @Column(name = "seminar_weight")
    private Integer seminar_weight;
}
