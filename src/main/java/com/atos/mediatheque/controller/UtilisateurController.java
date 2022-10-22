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

import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.UtilisateurRerository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api")
public class UtilisateurController {
	
@Autowired
private UtilisateurRerository utilisateurRerository;


	  @GetMapping("/utilisateurs")
	  public List<Utilisateur> getAll() {
		  
		  return utilisateurRerository.findAll();    
	  }
	  
	  @GetMapping("/utilisateur/by-id/{id}")
	  public ResponseEntity<Utilisateur> getOne(@PathVariable Long id) {
		  Utilisateur utilisateur = utilisateurRerository.findById(id).get();
		  if(utilisateur == null) {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
		  return new ResponseEntity<Utilisateur> (utilisateur, HttpStatus.OK);
	  }

//  
//	  @PostMapping("/utilisateur")
//	  public ResponseEntity<Utilisateur> save(@Valid @RequestBody Utilisateur utilisateur) {
//		  utilisateur = utilisateurRerository.save(utilisateur);
//		   return new ResponseEntity<Utilisateur> (utilisateur, HttpStatus.OK);
//	  }
//	  
//	  @PutMapping("/utilisateur/by-id/{id}")
//	  public Utilisateur update (@Valid @RequestBody Utilisateur utilisateur) {
//		  return utilisateurRerository.save(utilisateur);
//
//	  }
	  
	  //@DeleteMapping("/by-email/{email}")
	  @DeleteMapping("/by-id/{id}")
	  public void deleteUtilisateurById(@PathVariable("id") Long id) {
		  utilisateurRerository.deleteById(id);
		  //utilisateurRerository.deleteByEmail(email);
		  
	  }
}
