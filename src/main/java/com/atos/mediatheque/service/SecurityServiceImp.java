package com.atos.mediatheque.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atos.mediatheque.entity.Role;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.RoleRepository;
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
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Utilisateur saveNewUtilisateur(String email, String nom, String prenom, String motDePasse, String reMotDePasse) {
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
	public Role saveNewRole(String name) {
		Role role = roleRepository.findByName(name);
		if(role != null) throw new RuntimeException("Role "+ name + "allready existe");
		role = new Role();
		role.setName(name);
		Role roleSaved = roleRepository.save(role);
		return roleSaved;
	}

	@Override
	public void addRoleAUtilisateur(String nom, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRoleFromUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur loadByUserName(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
