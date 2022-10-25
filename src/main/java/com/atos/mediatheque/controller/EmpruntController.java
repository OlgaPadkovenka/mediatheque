package com.atos.mediatheque.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.ItemRepository;
import com.atos.mediatheque.repository.UtilisateurRerository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController 
{
	
	@Autowired
	private EmpruntRepository empruntRepository;
	@Autowired
	private UtilisateurRerository utilisateurRerository;
	@Autowired
	private ItemRepository itemRepository;
	
	  @GetMapping
	  public List<Emprunt> getAll() {
		return empruntRepository.findAll();
	  }
	
	  //avec user
	  @GetMapping("/by-id/{id}")
	  public ResponseEntity<Emprunt> getOne(@PathVariable Long id) {
		  Emprunt emprunt = empruntRepository.findById(id).get();
		  return new ResponseEntity<Emprunt>(emprunt, HttpStatus.OK);
	  }
	  
	  //emprunts d'un utilisateur
	  @GetMapping("/by-user/{id}")
	  public List<Emprunt> getEmpruntByUtilisateur(Utilisateur utilisateur) {
		 return empruntRepository.findEmpruntByUtilisateur(utilisateur);
	  }
	  	  
	  //post est vide ???
	  @PostMapping("/new")
	  public ResponseEntity<Emprunt> save(@Valid @RequestBody Emprunt emprunt) {
		   emprunt = empruntRepository.save(emprunt);
		   return new ResponseEntity<Emprunt> (emprunt, HttpStatus.OK);

	  }
	  
	  
	  

}
