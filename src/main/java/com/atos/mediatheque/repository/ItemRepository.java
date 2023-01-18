package com.atos.mediatheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.mediatheque.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	
	@Query("From CD ORDER BY TITRE")
	List<Item> findAllCd();
	
	@Query("From DVD ORDER BY TITRE")
	List<Item> findAllDvd();
	
	@Query("From Livre ORDER BY TITRE")
	List<Item> findAllLivre();

	@Query("From Item ORDER BY TITRE")
	Item findByIdItem(Integer nombreDExemplaires);
	
	@Query("From Item ORDER BY TITRE")
	List<Item> findAll();
	
	List<Item> findByTitre(String keyword);
	
		
	//SELECT * FROM CD JOIN EMPRUNT_ITEM ON CD.ID = EMPRUNT_ITEM.ITEM_ID
//	
	//@Query("FROM Item i INNER JOIN FETCH i.emprunts INNER JOIN FETCH Emprunt e WHERE e.utilisateur = utilisateur")
	//@Query(value="SELECT * FROM CD INNER JOIN EMPRUNT_ITEM WHERE ITEM_ID = CD.ID", nativeQuery = true)
	
	//SELECT * FROM CD INNER JOIN EMPRUNT_ITEM ON CD.ID = EMPRUNT_ITEM.ITEM_ID INNER JOIN EMPRUNT ON EMPRUNT.ID = EMPRUNT_ITEM.EMPRUNT_ID WHERE UTILISATEUR_ID = 7;
	
	//tous les items empruntés
	@Query("FROM Item i JOIN FETCH i.emprunts")
	List<Item> findItemEmprunte();	
}
