package com.atos.mediatheque;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"com.atos.mediatheque.web", "com.atos.mediatheque.security", "com.atos.mediatheque.service"})
public class MediathequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediathequeApplication.class, args);
		
		System.out.println("start application" + " " + new Date());
		

	}

}
