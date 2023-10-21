package com.esmt.memoire_back2023;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = "com.esmt.memoire_back2023")
public class MemoireBack2023Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MemoireBack2023Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello");
	}
}