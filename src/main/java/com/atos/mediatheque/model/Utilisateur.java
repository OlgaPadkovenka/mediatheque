package com.atos.mediatheque.model;

import javax.persistence.Entity; import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; import javax.persistence.Id;

import lombok.Getter; import lombok.Setter;

@Entity

@Getter

@Setter public class Utilisateur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom; private String prenom; private String email;
	private String motDePasse;

	public Utilisateur(Long id, String nom, String prenom, String email, String motDePasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}





}
