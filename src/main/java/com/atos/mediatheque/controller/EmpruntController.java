package com.atos.mediatheque.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.dto.EmpruntDTO;
import com.atos.mediatheque.service.EmpruntService;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {
	
	private EmpruntService empruntService;
	
	private EmpruntController(EmpruntService empruntService) {
		this.empruntService = empruntService;
	}
	
//	  @GetMapping
//	  public ResponseEntity<List<Emprunt>> getAllEmprunt() { 
//		  List<Emprunt> allEmprunts = empruntService.getAllEmprunt();
//		  //System.out.println(allEmprunts);
//		  return ResponseEntity.ok(allEmprunts);
//	  }
	
	  @GetMapping
	  public ResponseEntity<List<EmpruntDTO>> getAll() { 
		  List<EmpruntDTO> allEmprunts = empruntService.getAll();
		  //System.out.println(allEmprunts);
		  return ResponseEntity.ok(allEmprunts);
	  }
 
	  //Mapping id avec DTO
	  @GetMapping("/by-id/{id}")
	  public ResponseEntity<EmpruntDTO> getOne(@PathVariable Long id) { 
		  return ResponseEntity.ok(empruntService.getById(id));
	  }
}
