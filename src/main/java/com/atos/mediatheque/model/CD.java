package com.atos.mediatheque.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CD extends Item {
	
	private String duree;

	public CD(Long id, String titre, Integer nombreDExemplaires, Date dateDeParution, String nom, String duree) {
		super(id, titre, nombreDExemplaires, dateDeParution, nom);
		this.duree = duree;
	}


	
	

}
