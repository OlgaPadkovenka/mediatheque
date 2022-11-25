package com.atos.mediatheque.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Autowired
	private UserDetailsServiceImp userDetailsServiceImp;
	
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		 auth.userDetailsService(userDetailsServiceImp);
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
					authz.antMatchers("/").permitAll();
					authz.antMatchers("/cd", "/user/**").authenticated().and().formLogin().loginPage("/connection");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	        );
	    return http.build();

		}   
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	    return (web) -> web.ignoring()
	      .antMatchers("/h2-console/**");
	}

}
   

