package com.atos.mediatheque.entity;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="emprunt")
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empruntSequenceGenerator")
	@SequenceGenerator(name = "empruntSequenceGenerator", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(name="date_emprunt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateEmprunt;
	
	@Column(name="date_retour")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateRetour;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	 @ManyToMany
 	 @JoinTable(
 			 name = "emprunt_item",
 		     joinColumns = @JoinColumn(name = "emprunt_id", referencedColumnName = "id"),
 		     inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
 		   Set<Item> Items;
	 
		public Emprunt(Long id, Date dateEmprunt, Date dateRetour, Utilisateur utilisateur) {
			super();
		}
		
	public Emprunt(Long id, Date dateEmprunt, Date dateRetour, Utilisateur utilisateur, Set<Item> items) {
		super();
		this.id = id;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.utilisateur = utilisateur;
		Items = items;
	}

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

	public Set<Item> getItems() {
		return Items;
	}

	public void setItems(Set<Item> items) {
		Items = items;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


}
