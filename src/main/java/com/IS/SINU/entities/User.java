package com.IS.SINU.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition="character varying (30)")
    private String username;

    @Column(columnDefinition="character varying (255)")
    private String password;

    @Column(columnDefinition="character varying (30)")
    private String role;

    public User() {

    }

    public User (String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        roles.add(this.role);

        return roles;
    }
}
