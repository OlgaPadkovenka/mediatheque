package com.atos.mediatheque.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="emprunt")
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empruntSequenceGenerator")
	@SequenceGenerator(name = "empruntSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name="date_emprunt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateEmprunt;
	
	@Column(name="date_retour")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateRetour;
	
	// @OneToOne(cascade = CascadeType.ALL)
	 @ManyToOne
	 @JoinColumn(name="utilisateur_id")
	   // @JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
	    private Utilisateur utilisateur;
	
//	@ManyToMany
//	private CD cd;
//	
//	@ManyToMany
//	private DVD dvd;
//	
//	@ManyToMany
//	private Livre livre;
	
	 @ManyToMany
 	 @JoinTable(
 			 name = "emprunt_CD",
 		     joinColumns = @JoinColumn(name = "emprunt_id", referencedColumnName = "id"),
 		     inverseJoinColumns = @JoinColumn(name = "CD_id", referencedColumnName = "id"))
 		   Set<CD> CDs;
		
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

	public Set<CD> getCDs() {
		return CDs;
	}

	public void setCDs(Set<CD> cDs) {
		CDs = cDs;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	
//	public CD getCd() {
//		return cd;
//	}
//
//	public void setCd(CD cd) {
//		this.cd = cd;
//	}
	
//	public DVD getDvd() {
//		return dvd;
//	}
//
//	public void setDvd(DVD dvd) {
//		this.dvd = dvd;
//	}
//
//	public Livre getLivre() {
//		return livre;
//	}
//
//	public void setLivre(Livre livre) {
//		this.livre = livre;
//	}
	
}
