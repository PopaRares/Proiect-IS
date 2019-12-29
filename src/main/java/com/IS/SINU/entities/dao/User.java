package com.IS.SINU.entities.dao;

import com.IS.SINU.entities.Role;
import com.IS.SINU.entities.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
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
    private Long groupID;//temporary

    public String getRole() {
        return role.name();
    }

    public User(UserDto u){
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.email = u.getEmail();
        this.username = u.getUsername();
        this.role = Role.valueOf(u.getRole());
        this.groupID = assignGroup();
        this.activated = false;
    }

    public boolean getActivated() {
        return activated;
    }

    private long assignGroup() {
        Random random = new Random();
        return random.nextInt(Math.toIntExact(10L));
    }
}

