package com.atos.mediatheque.model;

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
@Table(name="livre")
public class Livre extends Item{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livreSequenceGenerator")
	@SequenceGenerator(name = "livreSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name="numero_ISBN")
	private Integer numeroISBN;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroISBN() {
		return numeroISBN;
	}

	public void setNumeroISBN(Integer numeroISBN) {
		this.numeroISBN = numeroISBN;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numeroISBN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		return Objects.equals(id, other.id) && Objects.equals(numeroISBN, other.numeroISBN);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livre [id=");
		builder.append(id);
		builder.append(", numeroISBN=");
		builder.append(numeroISBN);
		builder.append("]");
		return builder.toString();
	}
	

	
}
