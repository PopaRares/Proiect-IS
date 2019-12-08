package com.IS.SINU;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories("com.IS.SINU.repositories")
public class SinuApplication {
	public static void main(String[] args) {
		SpringApplication.run(SinuApplication.class, args);
	}
}
