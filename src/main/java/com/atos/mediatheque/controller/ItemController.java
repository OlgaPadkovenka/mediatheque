package com.atos.mediatheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.entity.Item;
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
	  public Item getOne(@PathVariable Long id) {
		 return itemRepository.findById(id).get(); 
	  }
	  
	  
//	  @PostMapping("/cd")
//	  public CD save(@RequestBody CD cd) {
//		  return itemRepository.save(cd);
//	  } 
////	  
//	  @PutMapping("/by-id/{id}")
//	  public ResponseEntity<CDDTO> update(@Valid @RequestBody CDDTO cdDTO) {
//		  return ResponseEntity.ok(cdService.save(cdDTO));
//	  }
//	    
	  @DeleteMapping("/by-id/{id}")
	  public void deleteByID(@PathVariable Long id) {
		  	itemRepository.deleteById(id);
	  }
}
