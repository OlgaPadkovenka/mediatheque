package com.atos.mediatheque;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"com.atos.mediatheque.web", "com.atos.mediatheque.security"})
public class MediathequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediathequeApplication.class, args);
		
		System.out.println("start application");

	}

}
