package com.atos.mediatheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Entity
@Table(name="dvd")
public class DVD extends Item {
		
	@Column(name="duree")
	private String duree;
	

	@Column(name="dvd_type")
	//@Enumerated(EnumType.STRING)
	private TypeDVD dvdType;
		
	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public TypeDVD getDvdType() {
		return dvdType;
	}

	public void setDvdType(TypeDVD dvdType) {
		this.dvdType = dvdType;
	}
	
}
