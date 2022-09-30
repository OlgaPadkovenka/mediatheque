package com.atos.mediatheque.dto;

import java.util.Date;
import java.util.Objects;


public class ItemDTO {

	private String titre;

	private Integer nombreDExemplaires;

	private Date DateDeParution;

	private String nom;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getNombreDExemplaires() {
		return nombreDExemplaires;
	}

	public void setNombreDExemplaires(Integer nombreDExemplaires) {
		this.nombreDExemplaires = nombreDExemplaires;
	}

	public Date getDateDeParution() {
		return DateDeParution;
	}

	public void setDateDeParution(Date dateDeParution) {
		DateDeParution = dateDeParution;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DateDeParution, nom, nombreDExemplaires, titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDTO other = (ItemDTO) obj;
		return Objects.equals(DateDeParution, other.DateDeParution) && Objects.equals(nom, other.nom)
				&& Objects.equals(nombreDExemplaires, other.nombreDExemplaires) && Objects.equals(titre, other.titre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemDTO [titre=");
		builder.append(titre);
		builder.append(", nombreDExemplaires=");
		builder.append(nombreDExemplaires);
		builder.append(", DateDeParution=");
		builder.append(DateDeParution);
		builder.append(", nom=");
		builder.append(nom);
		builder.append("]");
		return builder.toString();
	}
	
	

}
