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
    static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

    	// http.exceptionHandling().accessDeniedPage("/403");
        http
                .authorizeHttpRequests((authz) -> {
                            try {
                              
                                authz.antMatchers("/").permitAll().and().formLogin().defaultSuccessUrl("/user");
                                authz.antMatchers("/index**").permitAll();
                                authz.antMatchers("/register").permitAll();
                                authz.antMatchers("/create**").hasAnyAuthority("ADMIN");
                                authz.antMatchers("/edit**").hasAnyAuthority("ADMIN");
                                authz.antMatchers("/faire**").hasAnyAuthority("USER");
 
                                authz.and().logout().logoutSuccessUrl("/");
                               
                                

                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
              
                );
        
       
        
        return http.build();

    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .antMatchers("/h2-console/**");
    }

}
   

