package com.atos.mediatheque.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Item {
		
	@Column(name="titre")
	private String titre;
	
	@Column(name="nombre_d_exemplaires")
	private Integer nombreDExemplaires;
	
	@Column(name="date_de_parution")
	private Date DateDeParution;
	
	@Column(name="nom")
	private String nom;

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Integer getNombreDExemplaires() {
		return nombreDExemplaires;
	}
	public void setNombreDExemplaires(Integer nombreDExemplaires) {
		this.nombreDExemplaires = nombreDExemplaires;
	}
	public Date getDateDeParution() {
		return DateDeParution;
	}
	public void setDateDeParution(Date dateDeParution) {
		DateDeParution = dateDeParution;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
