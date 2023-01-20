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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//je ne vaux pas pour qu'elle soit instanciée
public abstract class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSequenceGenerator")
	@SequenceGenerator(name = "itemSequenceGenerator", allocationSize = 1)
	private Long id;
		
	@Column(name="titre", nullable=false)
	@NotEmpty(message = "Le titre ne peut pas être null")
	@Size(min = 1, max = 200)
	private String titre; 
	
	@Column(name="nombre_d_exemplaires")
	private Integer nombreDExemplaires;
	
	@Column(name="date_de_parution")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDeParution;
	
	@Column(name="nom", nullable=false)
	private String nom;
	
	@ManyToMany(mappedBy = "items", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
 	private Set<Emprunt> emprunts = new HashSet<>();
	
	public Item() {
		super();
	}
	
	public Item(Long id, String titre, Integer nombreDExemplaires, Date dateDeParution, String nom,
			Set<Emprunt> emprunts) {
		super();
		this.id = id;
		this.titre = titre;
		this.nombreDExemplaires = nombreDExemplaires;
		this.dateDeParution = dateDeParution;
		this.nom = nom;
		this.emprunts = emprunts;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(dateDeParution, id, nom, nombreDExemplaires, titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(dateDeParution, other.dateDeParution) && Objects.equals(id, other.id)
				&& Objects.equals(nom, other.nom) && Objects.equals(nombreDExemplaires, other.nombreDExemplaires)
				&& Objects.equals(titre, other.titre);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", titre=" + titre + ", nombreDExemplaires=" + nombreDExemplaires
				+ ", dateDeParution=" + dateDeParution + ", nom=" + nom + "]";
	}
	
	
	
}
