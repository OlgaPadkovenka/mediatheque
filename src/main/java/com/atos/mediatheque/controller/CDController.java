package com.atos.mediatheque.controller;

import java.util.List;

import org.apache.catalina.loader.ResourceEntry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.dto.CDDTO;
import com.atos.mediatheque.service.CDService;

@RestController
@RequestMapping("/api/cds")
public class CDController {
	
	private CDService cdService;
	
	//Controller
	private CDController(CDService cdService) {
		this.cdService = cdService;
	}

	//Mapping
	  @GetMapping
	  public ResponseEntity<List<CDDTO>> getAll() {
		  
		  List<CDDTO> allCDs = cdService.getAll();
		  
		  return ResponseEntity.ok(allCDs);
	  }
}
