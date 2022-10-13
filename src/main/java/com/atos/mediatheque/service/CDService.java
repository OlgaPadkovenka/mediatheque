package com.atos.mediatheque.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.mediatheque.dto.CDDTO;
import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.repository.CDRepository;

@Service
public class CDService {

	@Autowired
	private final CDRepository cdRepository;
	
	//Constructeur
	public CDService (CDRepository cdRepository) {
		this.cdRepository = cdRepository;
	}
	
	//Methode pour récupérer tous les cds avec DTO
		public List<CDDTO> getAll() {
			List<CD> allCDs = cdRepository.findAll();
			List<CDDTO> cdDTOs = new ArrayList<>();
			
			for(CD cd : allCDs) {
				CDDTO cdDTO = new CDDTO();
				//marche sans id aussi, dans ce cas-là l'id est null
				cdDTO.setId(cd.getId());
				cdDTO.setTitre(cd.getTitre());
				cdDTO.setNom(cd.getNom());
				//date format à revoir
				//2022-10-06T13:05:04.862+00:00
				cdDTO.setDateDeParution(cd.getDateDeParution());
				cdDTO.setNombreDExemplaires(cd.getNombreDExemplaires());
				cdDTO.setDuree(cd.getDuree());
				
				// Ajout dans le tableau de sorti
	        	cdDTOs.add(cdDTO);
			}
			
			return cdDTOs;
		}
		
		////Methode pour récupérer tous les cds sans DTO
//		public List<CD> getAllCD() {
//			List<CD> allCDs = cdRepository.findAll();
//			return allCDs;
//		}
		

		//Méthode pour récuréper un cd avec DTO
		
		public CDDTO getByIdCd(Long id){
			CD cd =  cdRepository.findById(id).get();
			
			CDDTO cdDTO = new CDDTO();
			cdDTO.setId(cd.getId());
			cdDTO.setNom(cd.getNom());
			cdDTO.setNombreDExemplaires(cd.getNombreDExemplaires());
			cdDTO.setTitre(cd.getTitre());
			cdDTO.setDateDeParution(cd.getDateDeParution());
			cdDTO.setDuree(cd.getDuree());
			
			return cdDTO;
		}
		

		private CD mapDTOToEntity (CDDTO cdDTO) {
			CD cd = new CD();
			cd.setId(cdDTO.getId());
			cd.setDateDeParution(cdDTO.getDateDeParution());
			cd.setDuree(cdDTO.getDuree());
			cd.setNom(cdDTO.getNom());
			cd.setNombreDExemplaires(cdDTO.getNombreDExemplaires());
			cd.setTitre(cdDTO.getTitre());
			return cd;
		}
		
		private CDDTO mapEntityToDTO(CD cdSaved) {
			CDDTO cdDTO = new CDDTO();
			cdDTO.setId(cdSaved.getId());
			cdDTO.setDateDeParution(cdSaved.getDateDeParution());
			cdDTO.setDuree(cdSaved.getDuree());
			cdDTO.setNom(cdSaved.getNom());
			cdDTO.setNombreDExemplaires(cdSaved.getNombreDExemplaires());
			cdDTO.setTitre(cdSaved.getTitre());
			
			return cdDTO;
		}
		
		public CDDTO save(CDDTO cdDTO) {
			CD cdToSave = mapDTOToEntity(cdDTO);
			CD cdSaved = cdRepository.save(cdToSave);
			return mapEntityToDTO(cdSaved);
		}
		
		
		@Transactional
		public void deleteById(Long id) {
			cdRepository.deleteById(id);
		}
		
		//map CDs à Emprunt
		public List<CDDTO> mapCDs(Set<CD> cds) {
			List<CDDTO> cdDTOs = new ArrayList<>();
			for(CD cd : cds) {
				CDDTO cdDTO = new CDDTO();
				cdDTO.setId(cd.getId());
				cdDTO.setNom(cd.getNom());
				cdDTO.setNombreDExemplaires(cd.getNombreDExemplaires());
				cdDTO.setTitre(cd.getTitre());
				cdDTO.setDateDeParution(cd.getDateDeParution());
				cdDTO.setDuree(cd.getDuree());
				
				cdDTOs.add(cdDTO);
			}
			return cdDTOs;
		}
		
		public List<CDDTO> getAllCD() {
			List<CD> allCDs = cdRepository.findAll();
			return mapCDs(new HashSet<>(allCDs));
		}		
		
}
