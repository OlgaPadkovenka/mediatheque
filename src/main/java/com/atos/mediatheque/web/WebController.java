package com.atos.mediatheque.web;

import java.security.Principal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.entity.DVD;
import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.entity.Livre;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.ItemRepository;
import com.atos.mediatheque.repository.UtilisateurRerository;


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
	
	@GetMapping("/showItem")
	public String showItem (Model model, Long id) {
		Item item = itemRepository.findById(id).orElse(null);
		model.addAttribute("item", item);
		return "items/showItem";
	}
				
	@GetMapping("/createCD")
	public String createCD(Model model) {
		model.addAttribute("cd", new CD());
		return "items/createCD";
	}
	
	@PostMapping("/saveCD")
	public String saveCD(Model model, CD cd) {
		itemRepository.save(cd);
		return "redirect:/";
	}
	
	@GetMapping("/editCD")
	public String editCD(Model model, Long id) {
		Item cd = itemRepository.findById(id).orElse(null);
		
		if(cd == null) throw new RuntimeException("Item introuvable");
		
		model.addAttribute("cd", cd);
		return "items/editCD";
	}
	
	@GetMapping("/createDVD")
	public String createDVD(Model model) {
		model.addAttribute("dvd", new DVD());
		return "items/createDVD";
	}
	
	@PostMapping("/saveDVD")
	public String saveDVD(Model model, DVD dvd) {
		itemRepository.save(dvd);
		return "redirect:/";
	}
	
	@GetMapping("/editDVD")
	public String editDVD(Model model, Long id) {
		Item dvd = itemRepository.findById(id).orElse(null);
		
		if(dvd == null) throw new RuntimeException("Item introuvable");
		
		model.addAttribute("dvd", dvd);
		return "items/editDVD";
	}
	
	@GetMapping("/createLivre")
	public String createLivre(Model model) {
		model.addAttribute("livre", new Livre());
		return "items/createLivre";
	}
	
	@PostMapping("/saveLivre")
	public String saveLivre(Model model, Livre livre) {
		itemRepository.save(livre);
		return "redirect:/";
	}
	
	@GetMapping("/editLivre")
	public String editLivre(Model model, Long id) {
		Item livre = itemRepository.findById(id).orElse(null);
		
		if(livre == null) throw new RuntimeException("Item introuvable");
		
		model.addAttribute("livre", livre);
		return "items/editLivre";
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
		return "items/livre";
	}
	
	@GetMapping("/delete")
	public String delete(Long id) {
		itemRepository.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/connection")
	public String connection (Model model) {
		return "/connection";
	}
	
//	@GetMapping("/user")
//	public String user (@AuthenticationPrincipal UserDetails userDetails, Model model, String email) {
//		String user = userDetails.getUsername();
//		 user = utilisateurRerository.findByEmail(email).toString();
//		//Utilisateur utilisateur = utilisateurRerository.findById(id).get();
//		if(user == null) throw new RuntimeException("Utilisateur introuvable");
//		model.addAttribute("user", user);
//		return "user";
//	}

	
	@GetMapping("/user")
	public String user (@CurrentSecurityContext(expression = "authentication.principal") Model model, Principal principal) {
		
		//Utilisateur utilisateur = utilisateurRerository.findByEmail(email);
		//Utilisateur utilisateur =  utilisateurRerository.findById(id).orElse(null);
		
		//if(utilisateur == null) throw new RuntimeException("Utilisateur introuvable");
		
		//model.addAttribute("utilisateur", utilisateur);
		//System.out.println(utilisateur.getEmail());
		
		System.out.println(principal.getName());
		String utilisateurConnecte = principal.getName();
		
		Utilisateur utilisateur = utilisateurRerository.findByEmail(utilisateurConnecte);
		model.addAttribute("utilisateur", utilisateur);
		
		System.out.println(utilisateur);
		
		return "user";
	}
	
//	@GetMapping("/user")
//	public String userProfil (Model model, SecurityService securityService, String email) {
//		
//		//Utilisateur user = utilisateurRerository.findByEmail(email);
//		Utilisateur utilisateur = securityService.loadByUserName(email);
//		
//		if(utilisateur == null) throw new RuntimeException("Utilisateur introuvable");
//		model.addAttribute("utilisateur", utilisateur);
//		System.out.println(utilisateur.getEmail());
//		return "user";
//	}
	
	@GetMapping("/user/{id}/emprunts")
	public Object empruntUser (Model model, @PathVariable Long id, Utilisateur utilisateur) {
		List<Emprunt> listEmprunts = empruntRepository.findEmpruntByUtilisateur(utilisateur);
		model.addAttribute("listEmprunts", listEmprunts);
		return "emprunt";
	}
}
