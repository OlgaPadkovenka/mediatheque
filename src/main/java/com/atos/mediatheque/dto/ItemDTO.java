package com.atos.mediatheque.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemDTO {
	
	private Long id;

	private String titre;

	private Integer nombreDExemplaires;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateDeParution;

	private String nom;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return dateDeParution;
	}

	public void setDateDeParution(Date dateDeParution) {
		this.dateDeParution = dateDeParution;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
