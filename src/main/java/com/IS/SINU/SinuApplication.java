package com.IS.SINU;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SinuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinuApplication.class, args);
	}
}
