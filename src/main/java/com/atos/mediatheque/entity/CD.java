package com.atos.mediatheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cd")
public class CD extends Item {
		
	@Column(name="duree")
	private String duree;


	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}
	
}
