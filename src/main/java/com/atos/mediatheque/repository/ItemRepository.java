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
	
		
	//SELECT * FROM CD JOIN EMPRUNT_ITEM ON CD.ID = EMPRUNT_ITEM.ITEM_ID
//	
//	@Query("SELECT i From Item i JOIN EMPRUNT_ITEM WHERE EMPRUNT_ID = ITEM_ID")
//	List<Item> findItemEmprunte();
//	
}
