package com.IS.SINU.security.activation;

import com.IS.SINU.entities.dao.User;

import java.security.SecureRandom;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ActivationToken {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    private static String getRandomString(int n) {
        SecureRandom random = new SecureRandom();
        String ret = "";
        for (int i = 0; i < n; i ++) {
            ret += LETTERS.charAt(random.nextInt(LETTERS.length()));
        }
        return ret;
    }

    public static String generate(){
        long timestamp = Instant.now().toEpochMilli();
        String randomString = getRandomString(13);
        System.out.println(randomString + " " + timestamp);
        return randomString + "-" + timestamp;
    }

    public static boolean verifyToken(String token) {
        long now = Instant.now().toEpochMilli();
        long then = Long.parseLong(token.substring(13));
        System.out.println(now + '\n' + then + '\n' + (now-then));
        return true;
    }
}