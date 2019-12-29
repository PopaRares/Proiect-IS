package com.IS.SINU.services;

import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    GroupRepository repository;

    @Override
    public Group getGroup(User user) {
        System.out.println(repository.getOne(10L));
        return null;
    }
}
