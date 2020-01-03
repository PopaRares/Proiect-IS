package com.IS.SINU.entities.dao;

import com.IS.SINU.entities.ScheduleIdentity;
import com.IS.SINU.entities.enums.Parity;
import com.IS.SINU.entities.enums.Weekday;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
@Data
public class ScheduleEntry {

    @EmbeddedId
    private ScheduleIdentity scheduleId;

    @Column(name = "day")
    @Enumerated(EnumType.STRING)
    private Weekday day;

    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;

    @Column(name = "parity")
    @Enumerated(EnumType.STRING)
    private Parity parity;

    @Column(name = "location")
    private String location;

}
