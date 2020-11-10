package com.c3.idiomas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UsuarioIdiomasApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioIdiomasApplication.class, args);
	}

}
