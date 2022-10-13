package com.atos.mediatheque.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
 
//	  @GetMapping
//	  public ResponseEntity<List<EmpruntDTO>> getById() { 
//		  List<EmpruntDTO> emprunt = empruntService.getById();
//		  //System.out.println(allEmprunts);
//		  return ResponseEntity.ok(emprunt);
//	  }
}
