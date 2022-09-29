package com.atos.mediatheque.model;

import java.util.Objects;
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
	Set<Utilisateur> utilisateurs;
	
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
		CD other = (CD) obj;
		return Objects.equals(duree, other.duree) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CD [id=");
		builder.append(id);
		builder.append(", duree=");
		builder.append(duree);
		builder.append("]");
		return builder.toString();
	}
	
	
}
