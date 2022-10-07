package com.atos.mediatheque.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="emprunt")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cdSequenceGenerator")
	@SequenceGenerator(name = "cdSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name="date_emprunt")
	private Date dateEmprunt;
	
	@Column(name="date_retour")
	private Date dateRetour;
	
	
	@OneToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private CD cd;
	
	@ManyToOne
	private DVD dvd;
	
	@ManyToOne
	private Livre livre;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}
	
	public DVD getDvd() {
		return dvd;
	}

	public void setDvd(DVD dvd) {
		this.dvd = dvd;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateEmprunt, dateRetour, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprunt other = (Emprunt) obj;
		return Objects.equals(dateEmprunt, other.dateEmprunt) && Objects.equals(dateRetour, other.dateRetour)
				&& Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emprunt [id=");
		builder.append(id);
		builder.append(", dateEmprunt=");
		builder.append(dateEmprunt);
		builder.append(", dateRetour=");
		builder.append(dateRetour);
		builder.append("]");
		return builder.toString();
	}

	
}
