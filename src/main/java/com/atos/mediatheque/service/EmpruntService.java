package com.atos.mediatheque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	
//	public void effectuerEmprunt(Utilisateur utilisateur, List<Item> items) {
//		List<Item> itemEmprunt = new ArrayList<>();
//		
//		for(Item item : items) {
//
//			Item it = itemRepository.findByIdItem(item.getNombreDExemplaires());
//			
//			it.setNombreDExemplaires(it.getNombreDExemplaires() - 1);
//
//		itemEmprunt.add(it);
//		
//		}
//	
//	}

}
