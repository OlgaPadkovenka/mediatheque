package com.atos.mediatheque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.repository.EmpruntRepository;

@Service
public class EmpruntService {
	
	private final EmpruntRepository empruntRepository;
	
	//Constructeur
	public EmpruntService (EmpruntRepository empruntRepository) {
		this.empruntRepository = empruntRepository;
	}
	
	////Methode pour récupérer tous les cds sans DTO
	public List<Emprunt> getAllEmprunt() {
		List<Emprunt> allEmprunts = empruntRepository.findAll();
		//Optional<Emprunt> allEmprunts = empruntRepository.findAllByUtilisateur(Long );
		return allEmprunts;
	}
	
}
