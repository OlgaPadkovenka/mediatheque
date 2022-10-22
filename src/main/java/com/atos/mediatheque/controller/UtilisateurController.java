package com.atos.mediatheque.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.UtilisateurRerository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
	
@Autowired
private UtilisateurRerository utilisateurRerository;

//constructeur

//
//	//Mapping
////	[
////	    {
////	        "nom": "olga",
////	        "prenom": "olga",
////	        "email": "olga@gmail.com",
////	        "motDePasse": "olga"
////	    }
////	]

	  @GetMapping
	     public List<Utilisateur> getAll() {
		    return utilisateurRerository.findAll();    
	  }
	  
	  @GetMapping("/by-id/{id}")
	  public Utilisateur getOne(@PathVariable Long id) {
		  return utilisateurRerository.findById(id).get();
	  }
  
	  @PostMapping
	  public void save (@Validated @RequestBody Utilisateur newUtilisateur) {
		   utilisateurRerository.save(newUtilisateur);
	  }
	  
	  @PutMapping("/by-id/{id}")
	  public Utilisateur update (@Valid @RequestBody Utilisateur utilisateur) {
		  return utilisateurRerository.save(utilisateur);

	  }
	  
	  //@DeleteMapping("/by-email/{email}")
	  @DeleteMapping("/by-id/{id}")
	  public void deleteUtilisateurById(@PathVariable("id") Long id) {
		  utilisateurRerository.deleteById(id);
		  //utilisateurRerository.deleteByEmail(email);
		  
	  }
}
