package com.atos.mediatheque.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Livre extends Item{
	
	private Integer numeroISBN;

	public Livre(Long id, String titre, Integer nombreDExemplaires, Date dateDeParution, String nom,
			Integer numeroISBN) {
		super(id, titre, nombreDExemplaires, dateDeParution, nom);
		this.numeroISBN = numeroISBN;
	}
	
	

}
