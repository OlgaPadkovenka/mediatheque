package com.atos.mediatheque.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	return http
    			.csrf().disable()
    			.authorizeRequests()
    			.antMatchers("/").permitAll()
    			.antMatchers("/profile").hasRole("USER")
    			.anyRequest().authenticated()
    			.and()
    			.httpBasic()
    			.and().build();
  
    }

}
