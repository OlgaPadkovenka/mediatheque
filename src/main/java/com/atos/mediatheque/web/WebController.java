package com.atos.mediatheque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.ItemRepository;
import com.atos.mediatheque.repository.UtilisateurRerository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class WebController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UtilisateurRerository utilisateurRerository;
	
	@Autowired
	private EmpruntRepository empruntRepository;

	@GetMapping("/")
	public String index(Model model) {
		List<Item> listItems = itemRepository.findAll();
		model.addAttribute("listItems", listItems);
		return "index";
	}
	
	@GetMapping("/user/{id}")
	public Object userProfil (Model model, @PathVariable Long id) {
		Utilisateur utilisateur = utilisateurRerository.findById(id).get();
		model.addAttribute("utilisateur", utilisateur);
		return "user";
	}
	
	@GetMapping("/user/{id}/emprunts")
	public Object empruntUser (Model model, @PathVariable Long id, Utilisateur utilisateur) {
		List<Emprunt> listEmprunts = empruntRepository.findEmpruntByUtilisateur(utilisateur);
		model.addAttribute("listEmprunts", listEmprunts);
		return "emprunt";
	}
}
