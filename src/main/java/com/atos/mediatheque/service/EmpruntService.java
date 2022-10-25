package com.atos.mediatheque.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.ItemRepository;
import com.atos.mediatheque.repository.UtilisateurRerository;

@Service
@Transactional
public class EmpruntService {
	
	
	@Autowired
	private EmpruntRepository empruntRepository;
	@Autowired
	private UtilisateurRerository utilisateurRerository;
	@Autowired
	private ItemRepository itemRepository;
	
	@Transactional
	public Emprunt faireEmprunt(Utilisateur utilisateur, Set<Item> items) {
	
		utilisateur = utilisateurRerository.findById(utilisateur.getId()).orElseThrow();
		
		int nombreItemsEmprunts = 0;
		
		for(Emprunt emprunt : utilisateur.getEmprunts()) {

			nombreItemsEmprunts += utilisateur.getEmprunts().size();
		
		}
	
		if(nombreItemsEmprunts + items.size() > 3) {
			System.out.println("vous ne pouvez pas emprunter plus de 3 items");
		}
		
		List<Item> itemsDisponibles = new ArrayList<>();
		
		for(Item item: items) {
			Item itemEmprunte = itemRepository.findById(item.getId()).get();
			
			if(itemEmprunte.getNombreDExemplaires() == 0) {
				System.out.println("L'item n'est pas disponible");
			} else {
				itemEmprunte.setNombreDExemplaires(itemEmprunte.getNombreDExemplaires() - 1);
				itemsDisponibles.add(itemEmprunte);
			}
		}
		
		Emprunt emprunt = new Emprunt();
		emprunt.setDateEmprunt(new Date());
		emprunt.setItems(itemsDisponibles);
		emprunt.setUtilisateur(utilisateur);
		
		empruntRepository.save(emprunt);
		
		return emprunt;
		
	}

}
