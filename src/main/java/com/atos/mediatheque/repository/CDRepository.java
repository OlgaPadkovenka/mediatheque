package com.atos.mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.mediatheque.entity.CD;

public interface CDRepository extends JpaRepository<CD, Long>{
	
	//int deleteById(Long id);
	void deleteById(Long id);
	
}
