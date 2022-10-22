package com.atos.mediatheque.entity;

import java.util.Objects;

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
	private String dvdType;
		
	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getDvdType() {
		return dvdType;
	}

	public void setDvdType(String dvdType) {
		this.dvdType = dvdType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DVD [duree=");
		builder.append(duree);
		builder.append(", dvdType=");
		builder.append(dvdType);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(duree, dvdType);
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
		return Objects.equals(duree, other.duree) && Objects.equals(dvdType, other.dvdType);
	}


	
}
