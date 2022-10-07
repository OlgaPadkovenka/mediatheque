package com.atos.mediatheque.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cd")
public class CD extends Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cdSequenceGenerator")
	@SequenceGenerator(name = "cdSequenceGenerator", allocationSize = 1)
	private Long id;
		
	@Column(name="duree")
	private String duree;
	
	@ManyToMany(mappedBy = "CDs")
 	Set<Emprunt> emprunts;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

		
}
