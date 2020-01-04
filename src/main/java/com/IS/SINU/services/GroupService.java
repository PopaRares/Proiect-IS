package com.IS.SINU.services;

import com.IS.SINU.entities.dao.Group;

public interface GroupService {
    Group getGroupByUsername(String username);
    Group getGroupById(Long id);
}
