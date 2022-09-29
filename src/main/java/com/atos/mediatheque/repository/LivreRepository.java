package com.atos.mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.mediatheque.entity.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long>{

}
