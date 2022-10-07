package com.atos.mediatheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.mediatheque.entity.CD;

public interface CDRepository extends JpaRepository<CD, Long>{
		
	void deleteById(Long id);
	
	//List<CD> findAllCD(Long id);

}
