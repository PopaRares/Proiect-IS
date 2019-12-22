package com.IS.SINU.services;

import com.IS.SINU.entities.dao.User;
import com.IS.SINU.entities.dto.UserDto;
import com.IS.SINU.exceptions.EmailExistsException;

public interface UserService {
    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;

    User activateAccount(String token);
}
