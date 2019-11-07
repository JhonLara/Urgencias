package com.ceiba.urgencias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.ceiba.urgencias")
public class UrgenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrgenciasApplication.class, args);
	}

}
