package com.IS.SINU.services;

import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.User;

public interface GroupService {
    Group getGroup(User user);
}
