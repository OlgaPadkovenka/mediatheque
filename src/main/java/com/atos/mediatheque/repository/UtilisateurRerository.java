package com.atos.mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.mediatheque.model.Utilisateur;

public interface UtilisateurRerository extends JpaRepository<Utilisateur, Long> {

}
