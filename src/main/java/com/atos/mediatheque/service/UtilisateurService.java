package com.atos.mediatheque.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.atos.mediatheque.dto.UtilisateurDTO;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.UtilisateurRerository;

@Service
public class UtilisateurService {
	
	private final UtilisateurRerository utilisateurRerository;
	
	//constructeur
	public UtilisateurService(UtilisateurRerository utilisateurRerository) {
		this.utilisateurRerository = utilisateurRerository;
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
        	utilisateurDTO.setEmail(utilisateur.getEmail());
        	utilisateurDTO.setMotDePasse(utilisateur.getMotDePasse());
        	utilisateurDTO.setNom(utilisateur.getNom());
        	utilisateurDTO.setPrenom(utilisateur.getPrenom());
        	
        	// Ajout dans le tableau de sorti
        	utilisateurDTOs.add(utilisateurDTO);
        }
		
		return utilisateurDTOs;
	}
}
