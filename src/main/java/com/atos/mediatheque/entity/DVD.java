package com.atos.mediatheque.entity;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="dvd")
public class DVD extends Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dvdSequenceGenerator")
	@SequenceGenerator(name = "dvdSequenceGenerator", allocationSize = 1)
	private Long id;

	@Column(name="duree")
	private String duree;
	

	@Column(name="dvd_type")
	private DVDType dvdType;
		
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

	public DVDType getDvdType() {
		return dvdType;
	}

	public void setDvdType(DVDType dvdType) {
		this.dvdType = dvdType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duree, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DVD other = (DVD) obj;
		return Objects.equals(duree, other.duree) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DVD [id=");
		builder.append(id);
		builder.append(", duree=");
		builder.append(duree);
		builder.append("]");
		return builder.toString();
	}
	
	
}
