package com.atos.mediatheque.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.atos.mediatheque.dto.CDDTO;
import com.atos.mediatheque.dto.EmpruntDTO;
import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.repository.EmpruntRepository;

@Service
public class EmpruntService {
	
	private final EmpruntRepository empruntRepository;
	private final CDService cdService;
	
	//Constructeur
	public EmpruntService (EmpruntRepository empruntRepository, CDService cdService) {
		this.empruntRepository = empruntRepository;
		this.cdService = cdService;
	}
	
	////Methode pour récupérer tous les cds dans l'emprunt avec DTO
	public List<EmpruntDTO> getAll() {
		List<Emprunt> allEmprunts = empruntRepository.findAll();
		List<EmpruntDTO> empruntDTOs = new ArrayList<>();
		
		for(Emprunt emprunt : allEmprunts) {
			EmpruntDTO empruntDTO = new EmpruntDTO();
			empruntDTO.setId(emprunt.getId());
			empruntDTO.setDateEmprunt(emprunt.getDateEmprunt());
			empruntDTO.setDateRetour(emprunt.getDateRetour());
			
			//ca marche avec utilisateur
//			  {
//			        "id": 1,
//			        "dateEmprunt": "2022-09-30T22:00:00.000+00:00",
//			        "dateRetour": null,
//			        "cds": [
//			            {
//			                "id": 1,
//			                "titre": "The college Dropout",
//			                "nombreDExemplaires": 20,
//			                "dateDeParution": "01-12-2003",
//			                "nom": "Kanye West",
//			                "duree": "125"
//			            }
//			        ],
//			        "utilisateur": 1
//			    },
			//http://localhost:8080/api/emprunts
			empruntDTO.setUtilisateur(emprunt.getUtilisateur().getId());
						
			//ajout de CD à Emprunt
			List<CDDTO> cdDTOs = cdService.mapCDs(emprunt.getCDs());
			empruntDTO.setCds(cdDTOs);
			
			empruntDTOs.add(empruntDTO);
			
		}
		
		return empruntDTOs;
	}
	
	public List<EmpruntDTO> mapEmprunts(Set<Emprunt> emprunts) {
		
		List<EmpruntDTO> empruntDTOs = new ArrayList<>();
		
		for(Emprunt emprunt : emprunts ) {
			
			EmpruntDTO empruntDTO = new EmpruntDTO();
			empruntDTO.setId(emprunt.getId());
			empruntDTO.setDateEmprunt(emprunt.getDateEmprunt());
			empruntDTO.setDateRetour(emprunt.getDateRetour());
			empruntDTO.setUtilisateur(emprunt.getUtilisateur().getId());
			//empruntDTO.setCds(emprunt.getCDs());
			
			empruntDTOs.add(empruntDTO);
			
			}
		
		return empruntDTOs;
		
	} 
	
	public List<EmpruntDTO> getAllEmprunt() {
		List<Emprunt> allEmprunts = empruntRepository.findAll();
		return mapEmprunts(new HashSet<>(allEmprunts));
	}
	
}
