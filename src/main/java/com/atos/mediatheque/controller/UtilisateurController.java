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
import com.atos.mediatheque.dto.UtilisateurDTO;
import com.atos.mediatheque.service.CDService;
import com.atos.mediatheque.service.EmpruntService;
import com.atos.mediatheque.service.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
	
	private UtilisateurService utilisateurService;
	//private final EmpruntService empruntService;
	//private final CDService cdService;
	
	//Constructeur
	private UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	//Mapping
//	[
//	    {
//	        "nom": "olga",
//	        "prenom": "olga",
//	        "email": "olga@gmail.com",
//	        "motDePasse": "olga"
//	    }
//	]
	  @GetMapping
	     public ResponseEntity<List<UtilisateurDTO>> getAll() {
		     // Etape 5 : Creation de ma resource (UtilisateurResource)
	         // Etape 6 : Quelle va etre la signature de ma methode ?
	         // Etape 7 : Quelles sont les codes HTTP qui je dois renvoyer ?
	         // Etape 8 : Ecriture du code de ma resource
		  
		  List<UtilisateurDTO> allUtilisateurs = utilisateurService.getAll();
		  
		  return ResponseEntity.ok(allUtilisateurs);
		  
	  }
	  
	  //Mapping avec id
	  @GetMapping("/by-id/{id}")
	  public ResponseEntity<UtilisateurDTO> getOne (@PathVariable Long id) {	
		return ResponseEntity.ok(utilisateurService.getById(id));
	  }
	  
	  
	  @PostMapping
	  public ResponseEntity<UtilisateurDTO> save (@Valid @RequestBody UtilisateurDTO utilisateurDTO) {
		  return ResponseEntity.ok(utilisateurService.save(utilisateurDTO));
	  }
	  
	  @PutMapping("/by-id/{id}")
	  public ResponseEntity<UtilisateurDTO> update (@Valid @RequestBody UtilisateurDTO utilisateurDTO) {
		  return ResponseEntity.ok(utilisateurService.save(utilisateurDTO));
	  }
	  
	  @DeleteMapping("/by-email/{email}")
	  public ResponseEntity<Void> deleteByEmail(@PathVariable String email) {
		  utilisateurService.deleteByEmail(email);
		  return ResponseEntity.ok().build();
	  }
}
