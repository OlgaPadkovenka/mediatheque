package com.atos.mediatheque.security;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.atos.mediatheque.entity.Utilisateur;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
	
	@Autowired
	private SecurityService securityService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur utilisateur = securityService.loadByUserName(email);

		//sans streams
//		Collection<GrantedAuthority> authorities = new ArrayList<>();
//		utilisateur.getRole().forEach(role -> {
//			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
//			authorities.add(authority);
//		});

		//Avec streams
		Collection<GrantedAuthority> authorities = 
				utilisateur.getRole()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
				.collect(Collectors.toList());
		
		
		User user = new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), authorities);
		return user;
	}

}
