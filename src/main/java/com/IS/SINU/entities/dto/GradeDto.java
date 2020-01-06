package com.IS.SINU.entities.dto;

import com.IS.SINU.entities.dao.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GradeDto {
    private Float grade;

    private Date date;

    @JsonProperty("class_id")
    private Long classId;

    @JsonProperty("student")
    private User student;
}
