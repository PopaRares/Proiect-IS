package com.IS.SINU.services;

import com.IS.SINU.entities.dao.Class;
import com.IS.SINU.entities.dao.ClassGroup;
import com.IS.SINU.entities.dao.Group;
import com.IS.SINU.entities.dao.User;
import com.IS.SINU.entities.dto.UserDto;
import com.IS.SINU.exceptions.EmailExistsException;

import java.util.List;
import java.util.Map;

public interface UserService {
    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;

    User activateAccount(String token);

    User getUser(String username);

    List<ClassGroup> getTeachingList(Long professorId);
}
