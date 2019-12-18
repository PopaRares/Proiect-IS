package com.IS.SINU.entities.dto;

import lombok.Data;
import validators.PasswordMatches;
import validators.ValidEmail;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class UserDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @ValidEmail
    @NotBlank
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    @Size(min=8, message="Password must be at least 8 characters")
    private String password;
    private String matchingPassword;

    @NotBlank
    private String role;

//    @NotNull
//    @NotEmpty
//    private int groupID;//temporary
}