package com.IS.SINU.services;

import com.IS.SINU.entities.dao.Group;

public interface GroupService {
    Group getGroup();
    Group getGroupById(Long id);
}
