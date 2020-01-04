package com.IS.SINU.entities.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "\"group\"")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Group {

    static final public Long GROUP_LIMIT = 10L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series_id")
    private Integer seriesID;

    public char getSeries() {
        return (char) ('A' + seriesID - 1);
    }

    @Column(name = "year")
    private Integer year;

    @Column(name = "faculty")
    private String faculty;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("lastName ASC, firstName ASC")
    @JoinColumn(name = "group_id")
    private Set<User> students;

}
