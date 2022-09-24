package com.atos.mediatheque.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private Integer nombreDExemplaires;
	private Date DateDeParution;
	private String nom;
	
	public Item(Long id, String titre, Integer nombreDExemplaires, Date dateDeParution, String nom) {
		super();
		this.id = id;
		this.titre = titre;
		this.nombreDExemplaires = nombreDExemplaires;
		DateDeParution = dateDeParution;
		this.nom = nom;
	}
	
	

}
