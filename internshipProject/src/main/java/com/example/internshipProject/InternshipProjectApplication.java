package com.example.internshipProject;

import com.example.internshipProject.service.InitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternshipProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InternshipProjectApplication.class, args);
	}

	@Autowired
	private InitializerService initializerService;

	@Override
	public void run(String... args) throws Exception {

		initializerService.initializeDatabaseFromFile("src/main/java/com/example/internshipProject/data/hotels.json");

	}
}
