package com.atos.mediatheque.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.UtilisateurRerository;




@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
	
@Autowired
private UtilisateurRerository utilisateurRerository;


	  @GetMapping
	  public List<Utilisateur> getAll() {
		  
		  return utilisateurRerository.findAll();    
	  }
	  
	  @GetMapping("/by-id/{id}")
	  public ResponseEntity<Utilisateur> getOne(@PathVariable Long id) {
		  Utilisateur utilisateur = utilisateurRerository.findById(id).get();
		  if(utilisateur == null) {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
		  return new ResponseEntity<Utilisateur> (utilisateur, HttpStatus.OK);
	  }

 
	  @PostMapping("/new")
	  public ResponseEntity<Utilisateur> save(@Valid @RequestBody Utilisateur utilisateur) {
		  utilisateur = utilisateurRerository.save(utilisateur);
		   return new ResponseEntity<Utilisateur> (utilisateur, HttpStatus.CREATED);
	  }
	  
	  
	  @PutMapping("/by-id/{id}")
	  public ResponseEntity<Utilisateur> update(@Valid @RequestBody Utilisateur utilisateur) {
		  utilisateur = utilisateurRerository.save(utilisateur);
		   return new ResponseEntity<Utilisateur> (utilisateur, HttpStatus.OK);
	  }
	  
	  //@DeleteMapping("/by-email/{email}")
	  @DeleteMapping("/by-id/{id}")
	  public void deleteUtilisateurById(@PathVariable("id") Long id) {
		  utilisateurRerository.deleteById(id);
		  //utilisateurRerository.deleteByEmail(email);
		  
	  }
}
