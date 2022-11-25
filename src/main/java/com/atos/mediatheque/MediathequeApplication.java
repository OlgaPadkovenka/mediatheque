package com.atos.mediatheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.atos.mediatheque.security.SecurityConfig;
import com.atos.mediatheque.security.UserDetailsServiceImp;

@SpringBootApplication(scanBasePackages={
"com.atos.mediatheque.web", "com.atos.mediatheque.security"})
//@ComponentScan(basePackages= {"com.atos.mediatheque.web"})
//@Import({ SecurityConfig.class })
public class MediathequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediathequeApplication.class, args);
		
		System.out.println("start application");
	}

}
