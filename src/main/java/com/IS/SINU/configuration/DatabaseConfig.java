package com.IS.SINU.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("spring.datasource")
public @Data class DatabaseConfig {
    private String url;
    private String username;
    private String password;
}
