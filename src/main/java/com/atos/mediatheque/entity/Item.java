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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//je ne vaux pas pour qu'elle soit instanciée
public abstract class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSequenceGenerator")
	@SequenceGenerator(name = "itemSequenceGenerator", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE)

	private Long id;
		
	@Column(name="titre")
	private String titre; 
	
	@Column(name="nombre_d_exemplaires")
	private Integer nombreDExemplaires;
	
	@Column(name="date_de_parution")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateDeParution;
	
	@Column(name="nom")
	private String nom;
	
	@ManyToMany(mappedBy = "Items", cascade = CascadeType.REMOVE)
	//@JsonManagedReference
	@JsonIgnore 
 	private Set<Emprunt> emprunts = new HashSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
		return dateDeParution;
	}
	public void setDateDeParution(Date dateDeParution) {
		this.dateDeParution = dateDeParution;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	
}
