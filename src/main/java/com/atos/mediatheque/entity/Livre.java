package com.atos.mediatheque.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="livre")
public class Livre extends Item{
		
	@Column(name="numero_ISBN")
	private String numeroISBN;


	public String getNumeroISBN() {
		return numeroISBN;
	}

	public void setNumeroISBN(String numeroISBN) {
		this.numeroISBN = numeroISBN;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroISBN);
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
		return Objects.equals(numeroISBN, other.numeroISBN);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livre [numeroISBN=");
		builder.append(numeroISBN);
		builder.append("]");
		return builder.toString();
	}


	
	
}
