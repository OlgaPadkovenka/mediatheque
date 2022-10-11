package com.atos.mediatheque.dto;

import java.util.ArrayList;
import java.util.List;

import com.atos.mediatheque.entity.Emprunt;

public class UtilisateurDTO {
	
	private Long id;
	
	private String nom;

	private String prenom;

	private String email;

	private String motDePasse;
	
	private List<EmpruntDTO> emprunts = new ArrayList<>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<EmpruntDTO> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<EmpruntDTO> emprunts) {
		this.emprunts = emprunts;
	}

	
}
