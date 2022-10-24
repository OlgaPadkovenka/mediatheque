package com.atos.mediatheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.mediatheque.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	
	@Query("From CD")
	List<Item> findAllCd();
	
	@Query("From DVD")
	List<Item> findAllDvd();
	
	@Query("From Livre")
	List<Item> findAllLivre();

	@Query("From Item")
	Item findByIdItem(Integer nombreDExemplaires);
	
	

}
