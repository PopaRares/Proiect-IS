package com.IS.SINU.entities;

import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.Teaching;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class ScheduleIdentity implements Serializable {

    //map this to two different objects!
    @ManyToOne
    @JoinColumn(name = "teaching_id")
    private Teaching teaching;

    @ManyToOne
    @JoinColumn(name = "group")
    private Group group;

}
