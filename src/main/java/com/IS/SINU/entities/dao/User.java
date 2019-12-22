package com.IS.SINU.entities.dao;

import com.IS.SINU.entities.Role;
import com.IS.SINU.entities.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Long id;

    @Column(name = "activated")
    private boolean activated;

    @Column(name = "activation_token")
    private String activationToken;

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

    public User(UserDto u){
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.email = u.getEmail();
        this.username = u.getUsername();
        this.role = Role.valueOf(u.getRole());
        this.groupID = 10;
        this.activated = false;
    }
}

