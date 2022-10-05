package com.atos.mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atos.mediatheque.entity.Utilisateur;

public interface UtilisateurRerository extends JpaRepository<Utilisateur, Long> {
	
	void deleteByEmail(String email);
	
	////la requete pour un update de l'utilisateur recherché par email
	//@Modifying
	//@Query("update Utilisateur u set where u.email = :email")
	//void updateUtilisateur(@Param(value="email") String email);

}
 