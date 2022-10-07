package com.atos.mediatheque.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.dto.CDDTO;
import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.service.CDService;

@RestController
@RequestMapping("/api/cds")
public class CDController {
	
	private CDService cdService;
	
	//Controller
	private CDController(CDService cdService) {
		this.cdService = cdService;
	}

	//Mapping avec DTO
	//ca ne marche pas
	  @GetMapping
	  public ResponseEntity<List<CDDTO>> getAll() {
		  List<CDDTO> allCDs = cdService.getAll();
		  System.out.println(allCDs);
		  return ResponseEntity.ok(allCDs);
		  
	  }
	  
	//Mapping sans DTO
	//ca marche
	  @GetMapping("/cd")
	  public ResponseEntity<List<CD>> getAllCD() { 
		  List<CD> allCDs = cdService.getAllCD();
		  System.out.println(allCDs);
		  return ResponseEntity.ok(allCDs);
	  }
	  
//	  {
//	        "nom": "olga3",
//	        "dateDeParution": "2022-10-06T13:05:04.862+00:00",
//	        "nombreDExemplaires": 34,
//	        "titre": "titre1",
//	        "duree": 45
//	}
//	
	  
	  @PostMapping
	  public ResponseEntity<CDDTO> save(@Valid @RequestBody CDDTO cdDTO) {
		  return ResponseEntity.ok(cdService.save(cdDTO));
	  } 
	  
	  @PutMapping("/by-id/{id}")
	  public ResponseEntity<CDDTO> update(@Valid @RequestBody CDDTO cdDTO) {
		  return ResponseEntity.ok(cdService.save(cdDTO));
	  }
	    
	  @DeleteMapping("/by-id/{id}")
	  public ResponseEntity<Void> deleteByID(@PathVariable Long id) {
		  cdService.deleteById(id);
		  return ResponseEntity.ok().build();
	  }
}
