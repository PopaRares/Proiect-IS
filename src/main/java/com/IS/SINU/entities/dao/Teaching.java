package com.IS.SINU.entities.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teaching")
@Data
public class Teaching {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", insertable = false, updatable = false)
    private Class class_name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id", insertable = false, updatable = false)
    private User professor;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "professor_id")
    private Long professorId;
}
