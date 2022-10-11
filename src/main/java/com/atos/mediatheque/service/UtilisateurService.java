package com.atos.mediatheque.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.atos.mediatheque.dto.CDDTO;
import com.atos.mediatheque.dto.EmpruntDTO;
import com.atos.mediatheque.dto.UtilisateurDTO;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.UtilisateurRerository;

@Service
public class UtilisateurService {
	
	private final UtilisateurRerository utilisateurRerository;
	private final EmpruntService empruntService;
	private final CDService cdService;
	
	//constructeur
	public UtilisateurService(UtilisateurRerository utilisateurRerository,
			EmpruntService empruntService, CDService cdService) {
		this.utilisateurRerository = utilisateurRerository;
		this.empruntService = empruntService;
		this.cdService = cdService;
	}

	//Methode pour récupérer tous les utilisateurs
	public List<UtilisateurDTO> getAll() {
		
        // Etape 1 : Je dois aller chercher mes utilisateurs dans ma base de données
        // Etape 2 : Je transforme mes entités utilisateurs en DTO
        // Etape 3 : Je renvoi ma liste de DTO
		
		 // Etape 1
		List<Utilisateur> allUtilisateurs = utilisateurRerository.findAll();
		
		// Instanciation de ma liste de DTO
		List<UtilisateurDTO> utilisateurDTOs = new ArrayList<>();
		
		  // Boucle sur les entites utilisateurs
        // Etape 2
        for (Utilisateur utilisateur : allUtilisateurs) {
        	
        	// Creation de mes DTOs
        	UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        	utilisateurDTO.setId(utilisateur.getId());
        	utilisateurDTO.setEmail(utilisateur.getEmail());
        	utilisateurDTO.setMotDePasse(utilisateur.getMotDePasse());
        	utilisateurDTO.setNom(utilisateur.getNom());
        	utilisateurDTO.setPrenom(utilisateur.getPrenom());
        	
        	//ca marche avec emprunts
//            {
//                "id": 1,
//                "nom": "Fleurisse",
//                "prenom": "Atangana",
//                "email": "bkzion@hotmail.fr",
//                "motDePasse": "laforce",
//                "emprunts": []
//            },
        	//http://localhost:8080/api/utilisateurs
        	//ajout emprunts à Utilisateur
        	List<EmpruntDTO> empruntDTOs = empruntService.mapEmprunts(utilisateur.getEmprunts());
        	utilisateurDTO.setEmprunts(empruntDTOs);
        	
        	// Ajout dans le tableau de sorti
        	utilisateurDTOs.add(utilisateurDTO);
        }
		
		return utilisateurDTOs;
	}
	
	//List<CDDTO> cdDTOs = cdService.mapCDs();
	//ajout cd à emprunts
	
	private Utilisateur mapDTOToEntity(UtilisateurDTO utilisateurDTO) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(utilisateurDTO.getId());
		utilisateur.setEmail(utilisateurDTO.getEmail());
		utilisateur.setMotDePasse(utilisateurDTO.getMotDePasse());
		utilisateur.setNom(utilisateurDTO.getNom());
		utilisateur.setPrenom(utilisateurDTO.getPrenom());
		return utilisateur;
	}
	
	private UtilisateurDTO mapEntityToDTO(Utilisateur utilisateurSaved) {
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
		utilisateurDTO.setId(utilisateurSaved.getId());
		utilisateurDTO.setEmail(utilisateurSaved.getEmail());
		utilisateurDTO.setMotDePasse(utilisateurSaved.getMotDePasse());
		utilisateurDTO.setNom(utilisateurSaved.getNom());
		utilisateurDTO.setPrenom(utilisateurSaved.getPrenom());
		
		return utilisateurDTO;
	}
	
	public UtilisateurDTO save(UtilisateurDTO utilisateurDTO) {
		Utilisateur utilisateurToSave = mapDTOToEntity(utilisateurDTO);
		Utilisateur utilisateurSaved = utilisateurRerository.save(utilisateurToSave);
		return mapEntityToDTO(utilisateurSaved);
	}
	
	@Transactional
	public void deleteByEmail(String email) {
		utilisateurRerository.deleteByEmail(email);
	}
	
//	//map Utilisateurs à Emprunt
//	public List<UtilisateurDTO> mapUtilisateurs(Set<Utilisateur> utilisateurs) {
//		List<UtilisateurDTO> utlisateurDTOs = new ArrayList<>();
//		
//		for(Utilisateur utilisateur : utilisateurs) {
//			UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
//			utilisateurDTO.setId(utilisateur.getId());
//			utilisateurDTO.setMotDePasse(utilisateur.getMotDePasse());
//			utilisateurDTO.setNom(utilisateur.getNom());
//			utilisateurDTO.setPrenom(utilisateur.getPrenom());
//			utilisateurDTO.setEmail(utilisateur.getEmail());
//
//			utlisateurDTOs.add(utilisateurDTO);
//
//		}
//		
//		return utlisateurDTOs;
//	}
//	
//	public List<UtilisateurDTO> getAllUtilisateur() {
//		List<Utilisateur> allUtilisateurs = utilisateurRerository.findAll();
//		return mapUtilisateurs(new HashSet<>(allUtilisateurs));
//	}
}
