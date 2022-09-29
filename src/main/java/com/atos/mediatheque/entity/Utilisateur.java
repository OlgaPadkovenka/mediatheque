package com.atos.mediatheque.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilisateurSequenceGenerator")
	@SequenceGenerator(name = "utilisateurSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mot_de_passe")
	private String motDePasse;
	
	 @ManyToMany
	 @JoinTable(
			 name = "utilisateur_CD",
		     joinColumns = @JoinColumn(name = "utilisateur_id", referencedColumnName = "id"),
		     inverseJoinColumns = @JoinColumn(name = "CD_id", referencedColumnName = "id"))
		   Set<CD> cds;
	
			
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	public Set<CD> getCds() {
		return cds;
	}
	public void setCds(Set<CD> cds) {
		this.cds = cds;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, motDePasse, nom, prenom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(motDePasse, other.motDePasse) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [id=");
		builder.append(id);
		builder.append(", nom=");
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
