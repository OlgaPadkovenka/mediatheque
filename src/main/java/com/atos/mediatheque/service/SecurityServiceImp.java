package com.atos.mediatheque.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atos.mediatheque.entity.RoleUser;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.RoleUserRepository;
import com.atos.mediatheque.repository.UtilisateurRerository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
//ca permet de logger des informations
@Slf4j
//constructeur avec tous les arguments de Lombok
@AllArgsConstructor
public class SecurityServiceImp implements SecurityService{
	
	private UtilisateurRerository utilisateurRerository;
	private RoleUserRepository roleUserRepository;
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Utilisateur saveNewUser(String email, String nom, String prenom, String motDePasse, String reMotDePasse) {
		if(!motDePasse.equals(reMotDePasse)) throw new RuntimeException("Passwords not match");
		String hashedMDP = passwordEncoder.encode(motDePasse);
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(email);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setMotDePasse(hashedMDP);
		Utilisateur utilisateurSaved = utilisateurRerository.save(utilisateur);
		return utilisateurSaved;
	};


	@Override
	public RoleUser saveNewRole(String roleName) {
		RoleUser roleUser = roleUserRepository.findByRoleName(roleName);
		
		if(roleUser != null) throw new RuntimeException("Role " + roleName+ "allready exist"); 
		
		roleUser = new RoleUser();
		roleUser.setRoleName(roleName);
		roleUserRepository.save(roleUser);
		return roleUser;
	}

	@Override
	public void addRoleToUser(String nom, String roleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRoleFromUser(String nom, String roleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur loadByUserName(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
