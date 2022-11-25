package com.atos.mediatheque.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImp userDetailsServiceImp;
	
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		System.out.println("config user");
		
		 auth.userDetailsService(userDetailsServiceImp);
}
	
	   @Bean
	   public static PasswordEncoder passwordEncoder() {
	       return new BCryptPasswordEncoder();
	   }
	 

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			  http.authorizeRequests()
		      .anyRequest().authenticated()
		      .and().formLogin();
		}  
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	    return (web) -> web.ignoring()
	      .antMatchers("/h2-console/**");
	}

}
   

