package com.atos.mediatheque.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.atos.mediatheque.dto.CDDTO;
import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.repository.CDRepository;

@Service
public class CDService {

	private final CDRepository cdRepository;
	
	//Constructeur
	public CDService (CDRepository cdRepository) {
		this.cdRepository = cdRepository;
	}
	
	//Methode pour récupérer tous les cds
		public List<CDDTO> getAll() {
			List<CD> allCDs = cdRepository.findAll();
			List<CDDTO> cdDTOs = new ArrayList<>();
			
			for(CD cd : allCDs) {
				CDDTO cdDTO = new CDDTO();
				cdDTO.setTitre(cd.getTitre());
				cdDTO.setDateDeParution(cd.getDateDeParution());
				cdDTO.setNom(cd.getNom());
				cdDTO.setDateDeParution(cd.getDateDeParution());
				cdDTO.setNombreDExemplaires(cd.getNombreDExemplaires());
				cdDTO.setDuree(cd.getDuree());
			}
			
			return cdDTOs;
		}
}
