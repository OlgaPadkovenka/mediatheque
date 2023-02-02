package com.atos.mediatheque.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
		
	//tous les items empruntés
	@Query("FROM Item i JOIN FETCH i.emprunts")
	List<Item> findItemEmprunte();	
	
	Page<Item> findByNomContains(String kw, Pageable pageable);
	
	@Query("From Item i WHERE i.titre like %:keyword%")
	List<Item> findByKeyword(@Param("keyword") String keyword);
}
