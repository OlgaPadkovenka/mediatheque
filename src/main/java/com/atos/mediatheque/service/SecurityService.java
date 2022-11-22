package com.atos.mediatheque.service;

import com.atos.mediatheque.entity.Role;
import com.atos.mediatheque.entity.Utilisateur;

public interface SecurityService {

	Utilisateur saveNewUtilisateur(String email, String nom, String prenom, String motDePasse, String reMotDePasse);

	Role saveNewRole(String name);

	void addRoleAUtilisateur(String nom, String name);

	void removeRoleFromUser();

	Utilisateur loadByUserName(String nom);

}