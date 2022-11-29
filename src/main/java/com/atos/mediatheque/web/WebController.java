package com.atos.mediatheque.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
//	@GetMapping("/show-item/{id}")
//	public String showItem(@PathVariable("id") Long id, @Valid Item item, Model model) {
//	    itemRepository.findById(id);
//	    return "items/show-item";
//	}
//	
//	@PutMapping("/update-item/{id}")
//	public String updateItem(@PathVariable("id") Long id, @Valid Item item, 
//	  BindingResult result, Model model) {
//	    itemRepository.save(item);
//	    return "redirect:/";
//	}
		
	@GetMapping("/delete")
	public String delete(Long id) {
		itemRepository.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/cd")
	public String cd(Model model) {
		List<Item> listCds = itemRepository.findAllCd();
		model.addAttribute("listCds", listCds);
		return "items/cd";
	}
	
	@GetMapping("/dvd")
	public String dvd(Model model) {
		List<Item> listDvds = itemRepository.findAllDvd();
		model.addAttribute("listDvds", listDvds);
		return "items/dvd";
	}
	
	@GetMapping("/livre")
	public String livre(Model model) {
		List<Item> listLivres = itemRepository.findAllLivre();
		model.addAttribute("listLivres", listLivres);
		//	return "redirect:/user/1";
		return "items/livre";
	}
	
	@GetMapping("/connection")
	public String connection (Model model) {
		return "/connection";
	}
	
	@GetMapping("/user/{email}")
	public Object userProfil (Model model, @PathVariable String email) {
		Utilisateur utilisateur = utilisateurRerository.findByEmail(email);
		//Utilisateur utilisateur = utilisateurRerository.findById(id).get();
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
