package com.IS.SINU.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("database")
public @Data class DatabaseConfig {
    private String address;
    private String port;
    private String username;
    private String password;
}
