 package com.atos.mediatheque.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.mediatheque.entity.RoleUser;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.RoleUserRepository;
import com.atos.mediatheque.repository.UtilisateurRerository;

import lombok.extern.slf4j.Slf4j;

@Service
//ca permet de logger des informations
@Slf4j
//transactional de Spring
@Transactional
public class SecurityServiceImp implements SecurityService{
	
	private UtilisateurRerository utilisateurRerository;
	private RoleUserRepository roleUserRepository;
	private PasswordEncoder passwordEncoder;
	
	
	public SecurityServiceImp(UtilisateurRerository utilisateurRerository, RoleUserRepository roleUserRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.utilisateurRerository = utilisateurRerository;
		this.roleUserRepository = roleUserRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public Utilisateur saveNewUser(String email, String nom, String prenom, String motDePasse,  String reMotDePasse) {
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
		RoleUser savedRoleUser = roleUserRepository.save(roleUser);
		return savedRoleUser;
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		//Je charge l'utilisateur
		Utilisateur utilisateur = utilisateurRerository.findByEmail(email);
		
		//vérifier si l'utilisateur n'est pas égale à null
		if(utilisateur == null) throw new RuntimeException("User not found");
		
		//Je charge des roles
		RoleUser roleUser = roleUserRepository.findByRoleName(roleName);
		
		//vérifier si le rôle n'est pas égale à null
		if(roleUser == null) throw new RuntimeException("Role not found");
		
		utilisateur.getRole().add(roleUser);
	}

	@Override
	public void removeRoleFromUser(String email, String roleName) {
		//Je charge l'utilisateur
		Utilisateur utilisateur = utilisateurRerository.findByEmail(email);
		
		//vérifier si l'utilisateur n'est pas égale à null
		if(utilisateur == null) throw new RuntimeException("User not found");
		
		//Je charge des roles
		RoleUser roleUser = roleUserRepository.findByRoleName(roleName);
		
		//vérifier si le rôle n'est pas égale à null
		if(roleUser == null) throw new RuntimeException("Role not found");
		
		utilisateur.getRole().remove(roleUser);
		
	}

	@Override
	public Utilisateur loadByUserName(String email) {
		// TODO Auto-generated method stub
		return utilisateurRerository.findByEmail(email);
	}
	
}
