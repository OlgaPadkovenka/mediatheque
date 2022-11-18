package com.atos.mediatheque.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
		
	@Bean
public InMemoryUserDetailsManager userDetailsService() {
		
		System.out.println("config user");
		
		  UserDetails user = User
		            .withUsername("user")
		            .password(passwordEncoder().encode("password"))
		            .roles("USER")
		            .build();
		return new InMemoryUserDetailsManager(user);

}
	
	   @Bean
	   public static PasswordEncoder passwordEncoder() {
	       return new BCryptPasswordEncoder();
	   }
	 

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
        http
        .authorizeHttpRequests((authz) -> {
			try {
				authz
				    .anyRequest().authenticated()
				    .and().formLogin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        );
    return http.build();
		
	} 
	

}
   

