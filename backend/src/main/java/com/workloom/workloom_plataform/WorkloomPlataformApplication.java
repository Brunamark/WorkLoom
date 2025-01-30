package com.workloom.workloom_plataform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.workloom.workloom_plataform.domain")
@ComponentScan(basePackages = "com.workloom.workloom_plataform")

public class WorkloomPlataformApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(WorkloomPlataformApplication.class, args);
	}

	

}
