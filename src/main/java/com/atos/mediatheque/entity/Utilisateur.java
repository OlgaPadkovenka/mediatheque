package com.atos.mediatheque.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="utilisateur")
public class Utilisateur{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilisateurSequenceGenerator")
	@SequenceGenerator(name = "utilisateurSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name="nom")
	@NotEmpty(message = "Le nom ne peut pas être vide")
    @Size(min = 2, max = 200, message = "Le nom doit avoir entre 2 et 200 caractères")
	private String nom;
	
	@Column(name="prenom")
	@NotEmpty(message = "Le prénom ne peut pas être vide")
    @Size(min = 2, max = 200, message = "Le prénom doit avoir entre 2 et 200 caractères")
	private String prenom;
	
	@Column(name="email", unique = true)
	@NotEmpty(message = "L'email ne peut pas être vide")
	@Email(message="L'email n'est pas correcte")
	private String email;
	
	@Column(name="mot_de_passe")
	@Pattern(regexp = "\\A(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])\\S{8,}\\z",
	message = "Le mot de passe doit avoir au moins 8 caractères sans espaces,"
			+ " un chiffre, une lettre majuscule et minuscule, un caractère spécial! "
			+ "Bon courage à vous!")
	private String motDePasse; 
	
	private String reMotDePasse; 
	
	
	@OneToMany(mappedBy="utilisateur", cascade = CascadeType.REMOVE)
	private Set<Emprunt> emprunts = new HashSet<>();
	
	
	//chanque fois quand je charge un utilisateur, Hibernate charge toutes ses roles en mémoire
	@ManyToMany(fetch = FetchType.EAGER)
	private List<RoleUser> role = new ArrayList<>();
	
	public Utilisateur() {
//		super();
	}
	
	public Utilisateur(Long id, String nom, String prenom, String email, String motDePasse, Set<Emprunt> emprunts,
			List<RoleUser> role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.emprunts = emprunts;
		this.role = role;
	}

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
	
	public String getReMotDePasse() {
		return reMotDePasse;
	}

	public void setReMotDePasse(String reMotDePasse) {
		this.reMotDePasse = reMotDePasse;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	public List<RoleUser> getRole() {
		return role;
	}

	public void setRole(List<RoleUser> role) {
		this.role = role;
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
