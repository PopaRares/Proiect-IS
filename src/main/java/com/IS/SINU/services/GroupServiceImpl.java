package com.IS.SINU.services;

import com.IS.SINU.entities.CurrentUser;
import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.enums.Role;
import com.IS.SINU.exceptions.InvalidGroupIdException;
import com.IS.SINU.exceptions.UserWrongRoleException;
import com.IS.SINU.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    GroupRepository repository;

    public Group getGroup() {
        if(CurrentUser.role != Role.STUDENT) {
            throw new UserWrongRoleException(CurrentUser.username, Role.STUDENT);
        }
        Group G = repository.findByUsername(CurrentUser.username);
        return G;
    }

    @Override
    public Group getGroupById(Long id) {
        Optional<Group> G;
        G = repository.findById(id);
        if(G.isPresent()) {
            return G.get();
        } else {
            throw new InvalidGroupIdException(id);
        }
    }

}
