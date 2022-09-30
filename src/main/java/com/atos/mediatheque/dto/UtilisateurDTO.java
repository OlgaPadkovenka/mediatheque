package com.atos.mediatheque.dto;

import java.util.Objects;

public class UtilisateurDTO {
	
	//private Long id;
	
	private String nom;

	private String prenom;

	private String email;

	private String motDePasse;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, motDePasse, nom, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtilisateurDTO other = (UtilisateurDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(motDePasse, other.motDePasse)
				&& Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UtilisateurDTO [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append("]");
		return builder.toString();
	}
	

}
