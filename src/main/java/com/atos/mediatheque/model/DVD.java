package com.atos.mediatheque.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DVD extends Item {

	private String duree;
	private Enum type;
	//blue-ray, normal
	
	public DVD(Long id, String titre, Integer nombreDExemplaires, Date dateDeParution, String nom, String duree,
			Enum type) {
		super(id, titre, nombreDExemplaires, dateDeParution, nom);
		this.duree = duree;
		this.type = type;
	}
	
	
}
