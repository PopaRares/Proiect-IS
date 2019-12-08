package com.IS.SINU.entities.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "group_id")
    private int groupID;//temporary

    public String getRole() {
        return role.name();
    }
}

enum Role {
    STUDENT,
    PROFESSOR,
    ADMIN
}