package com.atos.mediatheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Utilisateur;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long>{
	
	//les emprunts d'un utilisateur
	@Query("Select e from Emprunt e WHERE e.utilisateur = :utilisateur")
	List<Emprunt> findEmpruntByUtilisateur(Utilisateur utilisateur);
	
}
