package com.atos.mediatheque.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="emprunt")
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empruntSequenceGenerator")
	@SequenceGenerator(name = "empruntSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name="date_emprunt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyy")
	private Date dateEmprunt;
	
	@Column(name="date_retour")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateRetour;
	
	@ManyToOne
	@JsonIgnore
	//@JsonManagedReference
	private Utilisateur utilisateur;
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL})
 	 @JoinTable(
 			 name = "emprunt_item",
 		     joinColumns = @JoinColumn(name = "emprunt_id", referencedColumnName="id"),
 		     inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName="id"))
 		   private Set<Item> items = new HashSet<>();
	 
	 
		public Emprunt() {
			super();
		}
		

	public Emprunt(Long id, Date dateEmprunt, Date dateRetour, Utilisateur utilisateur, Set<Item> items) {
			super();
			this.id = id;
			this.dateEmprunt = dateEmprunt;
			this.dateRetour = dateRetour;
			this.utilisateur = utilisateur;
			this.items = items;
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
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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
