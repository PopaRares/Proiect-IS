package com.IS.SINU.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
