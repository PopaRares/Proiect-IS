package com.IS.SINU.entities.dao;

import com.IS.SINU.entities.SubjectType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "class")
@Data
public class Class {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    @Column(name = "type")
    private SubjectType type;

    @ManyToOne
    @JoinColumn(name = "id")
    private Subject subject;
}
