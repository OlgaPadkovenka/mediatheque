package com.atos.mediatheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atos.mediatheque.entity.Emprunt;

public interface EmpruntRepository extends JpaRepository <Emprunt, Long>{
	
	
//	@Query("SELECT e.id FROM Emprunt e INNER JOIN Utilisateur u WHERE u.id = :utilisateurId")
//	List<Emprunt> findAllByUtilisateur(@Param("utilisateurId") Long utilisateurId);

}
