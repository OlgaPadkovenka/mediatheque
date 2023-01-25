package com.atos.mediatheque.entity;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(duree);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CD other = (CD) obj;
		return Objects.equals(duree, other.duree);
	}

	@Override
	public String toString() {
		return "CD [duree=" + duree + "]";
	}
	
	
	
}
