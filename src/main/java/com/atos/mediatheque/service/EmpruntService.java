package com.atos.mediatheque.service;

import java.util.ArrayList;
import java.util.List;

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
	
	////Methode pour récupérer tous les cds sans DTO
	public List<EmpruntDTO> getAll() {
		List<Emprunt> allEmprunts = empruntRepository.findAll();
		List<EmpruntDTO> empruntDTOs = new ArrayList<>();
		
		for(Emprunt emprunt : allEmprunts) {
			EmpruntDTO empruntDTO = new EmpruntDTO();
			empruntDTO.setId(emprunt.getId());
			empruntDTO.setDateEmprunt(emprunt.getDateEmprunt());
			empruntDTO.setDateRetour(emprunt.getDateRetour());
			
			List<CDDTO> cdDTOs = cdService.mapCDs(emprunt.getCDs());
			empruntDTO.setCds(cdDTOs);
			empruntDTOs.add(empruntDTO);
		}
		
		return empruntDTOs;
	}
	
}
