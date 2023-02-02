package com.atos.mediatheque.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="livre")
public class Livre extends Item {
		
	@Column(name="numero_ISBN")
	private String numeroISBN;

	public Livre(String numeroISBN) {
		super();
		this.numeroISBN = numeroISBN;
	}
	
	public Livre() {
		super();
	}

	public String getNumeroISBN() {
		return numeroISBN;
	}

	public void setNumeroISBN(String numeroISBN) {
		this.numeroISBN = numeroISBN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroISBN);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		return Objects.equals(numeroISBN, other.numeroISBN);
	}

	@Override
	public String toString() {
		return "Livre [numeroISBN=" + numeroISBN + "]";
	}
	
}
