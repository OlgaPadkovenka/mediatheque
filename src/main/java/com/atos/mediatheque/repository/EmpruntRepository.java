package com.atos.mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.mediatheque.entity.Emprunt;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long>{

}
