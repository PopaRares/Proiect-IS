package com.IS.SINU.exceptions;

import com.IS.SINU.entities.enums.Role;
import lombok.Data;

@Data
public class UserIsNotRightRoleException extends SINU_Exception {
    private String username;
    private Role role;

    public UserIsNotRightRoleException(String username, Role role) {
        super();
        this.username = username;
        this.role = role;
        message = "The user " + username + " is not registered as a " + role + ".";
    }
}
