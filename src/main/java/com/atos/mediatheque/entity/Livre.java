package com.atos.mediatheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="livre")
public class Livre extends Item{
		
	@Column(name="numero_ISBN")
	private Integer numeroISBN;
	
	public Integer getNumeroISBN() {
		return numeroISBN;
	}

	public void setNumeroISBN(Integer numeroISBN) {
		this.numeroISBN = numeroISBN;
	}
	
}
