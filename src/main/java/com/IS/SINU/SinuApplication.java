package com.IS.SINU;

import com.IS.SINU.configuration.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SinuApplication implements CommandLineRunner {

	@Autowired
	private DatabaseConfig database;

	public static void main(String[] args) {
		SpringApplication.run(SinuApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(database);
	}
}
