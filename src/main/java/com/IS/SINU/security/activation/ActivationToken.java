package com.IS.SINU.security.activation;

import java.security.SecureRandom;
import java.time.Instant;

public class ActivationToken {//kinda hacky
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
        return randomString + "-" + timestamp;
    }

    public static boolean verifyToken(String token) {
        long now = Instant.now().toEpochMilli();
        long then = Long.parseLong(token.substring(14));
        return now - then > 86400000;//one day
    }
}