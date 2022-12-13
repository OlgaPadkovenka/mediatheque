package com.atos.mediatheque.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.entity.Utilisateur;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long>{
	
	//les emprunts d'un utilisateur
	//@Query("Select e from Emprunt e WHERE e.utilisateur = :utilisateur")
	//@Query("Select e from Emprunt e join Item i on e.id = i.id WHERE e.utilisateur = :utilisateur")
	List<Emprunt> findEmpruntByUtilisateur(Utilisateur utilisateur);
	
//	List<Emprunt> findByItems(Set<Item> items);
	
	
//		@Query("Select i from Item i JOIN Emprunt e WHERE e.item = :item")
//	List<Emprunt> findEmpruntByUtilisateur(Item item);
	

////	//cds empruntés
	@Query(value="SELECT * FROM EMPRUNT join emprunt_item on emprunt_item.emprunt_id = emprunt.id join cd on cd.id = emprunt_item.item_id", nativeQuery = true)
	List<Emprunt> findItemEmpente();
//
	//@Query("Select e from Emprunt e join Item i WHERE e.emprunt_id = :item")
	//Set <Emprunt> findByEmprunt_item_id(Long id);
//	List<Item> findByItems_Id(Long id);
}
