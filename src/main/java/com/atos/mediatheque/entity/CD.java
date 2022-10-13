package com.atos.mediatheque.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
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
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cdSequenceGenerator")
//	@SequenceGenerator(name = "cdSequenceGenerator", allocationSize = 1)
//	private Long id;
		
	@Column(name="duree")
	private String duree;
	
	@ManyToMany(mappedBy = "CDs", cascade = CascadeType.REMOVE)
 	private Set<Emprunt> emprunts = new HashSet<>();
	

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CD [duree=");
		builder.append(duree);
		builder.append("]");
		return builder.toString();
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

	
		
}
