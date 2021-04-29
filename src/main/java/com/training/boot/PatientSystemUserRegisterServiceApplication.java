package com.training.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = "{ com.training.ps.entities }")
public class PatientSystemUserRegisterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientSystemUserRegisterServiceApplication.class, args);
	}

}
