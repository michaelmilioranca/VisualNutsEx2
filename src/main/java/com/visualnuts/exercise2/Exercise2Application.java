package com.visualnuts.exercise2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Exercise2Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise2Application.class, args);
	}

}
