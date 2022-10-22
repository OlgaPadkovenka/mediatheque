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

import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.entity.DVD;
import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.entity.Livre;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.ItemRepository;


@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;

	  @GetMapping
	  public List<Item> getAll() {
		return itemRepository.findAll();
	  }
	  
	  @GetMapping("/cd")
	  public List<Item> getAllCd() {
		  return itemRepository.findAllCd();
		    
	  }
	  
	  @GetMapping("/dvd")
	  public List<Item> getAllDvd() {
		  return itemRepository.findAllDvd();
	  }
	  
	  @GetMapping("/livre")
	  public List<Item> getAllLivre() {
		  return itemRepository.findAllLivre();
	  }
	  
	  @GetMapping("/by-id/{id}")
	  public ResponseEntity<Item>  getOne(@PathVariable Long id) {
		  Item item = itemRepository.findById(id).get();
		  if(item == null) {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
		  return new ResponseEntity<Item> (item, HttpStatus.OK); 
	  }
	  
	  @PostMapping("/cd")
	  public ResponseEntity<CD> save(@Valid @RequestBody CD cd) {
		  cd = itemRepository.save(cd);
		  return new ResponseEntity<CD> (cd, HttpStatus.OK);
	  } 
	  
	  @PostMapping("/dvd")
	  public ResponseEntity<DVD> save(@Valid @RequestBody DVD dvd) {
		  dvd = itemRepository.save(dvd);
		  return new ResponseEntity<DVD> (dvd, HttpStatus.OK);
	  } 
	  
	  @PostMapping("/livre")
	  public ResponseEntity<Livre> save(@Valid @RequestBody Livre livre) {
		  livre = itemRepository.save(livre);
		  return new ResponseEntity<Livre> (livre, HttpStatus.OK);
	  } 
	  
	  @PutMapping("/cd/by-id/{id}")
	  public ResponseEntity<CD> update(@Valid @RequestBody CD cd) {
		  cd = itemRepository.save(cd);
		  return new ResponseEntity<CD> (cd, HttpStatus.OK);
	  }
	  
	  @PutMapping("/dvd/by-id/{id}")
	  public ResponseEntity<DVD> update(@Valid @RequestBody DVD dvd) {
		  dvd = itemRepository.save(dvd);
		  return new ResponseEntity<DVD> (dvd, HttpStatus.OK);
	  }
	  
	  @PutMapping("/livre/by-id/{id}")
	  public ResponseEntity<Livre> update(@Valid @RequestBody Livre livre) {
		  livre = itemRepository.save(livre);
		  return new ResponseEntity<Livre> (livre, HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/by-id/{id}")
	  public void deleteByID(@PathVariable Long id) {
		  	itemRepository.deleteById(id);
	  }
}
