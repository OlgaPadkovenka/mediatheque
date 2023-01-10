package com.atos.mediatheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Utilisateur;


public interface EmpruntRepository extends JpaRepository<Emprunt, Long>{
	
	//les emprunts d'un utilisateur
	@Query("Select e from Emprunt e WHERE e.utilisateur = :utilisateur")
	//@Query("Select e from Emprunt e join Item i on e.id = i.id WHERE e.utilisateur = :utilisateur")
	List<Emprunt> findEmpruntByUtilisateur(Utilisateur utilisateur);
	
	
//	List<Emprunt> findByItems();
//
//	@Query(value="SELECT * FROM EMPRUNT JOIN EMPRUNT_ITEM ON EMPRUNT_ITEM.EMPRUNT_ID = EMPRUNT.ID JOIN CD ON CD.ID = EMPRUNT_ITEM.ITEM_ID", nativeQuery = true)
	//	@Query("FROM Item i JOIN FETCH i.emprunts")
	@Query("FROM Emprunt e JOIN FETCH e.items WHERE e.utilisateur = :utilisateur")
	List<Emprunt> findItemEmpent(Utilisateur utilisateur);

	//@Query("Select e from Emprunt e join Item i WHERE e.emprunt_id = :item")
	//Set <Emprunt> findByEmprunt_item_id(Long id);
//	List<Item> findByItems_Id(Long id);
}
