package com.atos.mediatheque.security;

import com.atos.mediatheque.entity.RoleUser;
import com.atos.mediatheque.entity.Utilisateur;

public interface SecurityService {

	Utilisateur saveNewUser(String email, String nom, String prenom, String motDePasse,  String reMotDePasse);

	RoleUser saveNewRole(String roleName);

	void addRoleToUser(String nom, String roleName);

	void removeRoleFromUser(String nom, String roleName);

	Utilisateur loadByUserName(String email);

}