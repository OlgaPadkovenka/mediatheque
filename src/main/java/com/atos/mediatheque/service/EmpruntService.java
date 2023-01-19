package com.atos.mediatheque.service;

import java.security.Principal;
import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.ItemRepository;
import com.atos.mediatheque.repository.UtilisateurRerository;

@Service
@Transactional
public class EmpruntService {
	
	
	private EmpruntRepository empruntRepository;

	private UtilisateurRerository utilisateurRerository;

	private ItemRepository itemRepository;
	
	
	public EmpruntService(EmpruntRepository empruntRepository, UtilisateurRerository utilisateurRerository,
			ItemRepository itemRepository) {
		super();
		this.empruntRepository = empruntRepository;
		this.utilisateurRerository = utilisateurRerository;
		this.itemRepository = itemRepository;
	}




	@Transactional
	public void faireEmprunt(@CurrentSecurityContext(expression = "authentication.principal") Model model, Long id, Principal principal) {
		Item item = itemRepository.findById(id).orElse(null);
		
		Integer exemplaire = item.getNombreDExemplaires() - 1;
		item.setNombreDExemplaires(exemplaire);
	
		String utilisateurConnecte = principal.getName();
		Utilisateur utilisateur = utilisateurRerository.findByEmail(utilisateurConnecte);
		
		Emprunt emprunt = new Emprunt();
		emprunt.setUtilisateur(utilisateur);
		emprunt.setDateEmprunt(new Date());
		
		Set<Item> listItem = new HashSet<>();
		
		listItem.add(item);
		
		emprunt.setItems(listItem);
		
		empruntRepository.save(emprunt);

	}

}
