package com.atos.mediatheque;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import ma.glasnost.orika.MapperFacade;

@SpringBootApplication(scanBasePackages={
"com.atos.mediatheque.web", "com.atos.mediatheque.security", "com.atos.mediatheque.service"})
public class MediathequeApplication {

	public static void main(String[] args) {
	
		
		SpringApplication.run(MediathequeApplication.class, args);
		
		System.out.println("start application" + " " + new Date());
		
	}
	
	@Bean
	public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    
	    // Autoriser uniquement l'origine spécifique de votre application Angular
	    config.addAllowedOrigin("http://localhost:4200");

	    config.setAllowCredentials(true);
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    source.registerCorsConfiguration("/**", config);
	    
	    return new CorsFilter(source);
	}

}
