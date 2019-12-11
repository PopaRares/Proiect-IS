package com.IS.SINU.entities.dto;

import com.IS.SINU.entities.Role;
import lombok.Data;
import validators.PasswordMatches;
import validators.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    private String role;

//    @NotNull
//    @NotEmpty
//    private int groupID;//temporary
}