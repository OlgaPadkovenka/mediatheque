package com.atos.mediatheque.web;

import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
	
	public WebController(ItemRepository itemRepository, UtilisateurRerository utilisateurRerository,
			EmpruntRepository empruntRepository) {
		super();
		this.itemRepository = itemRepository;
		this.utilisateurRerository = utilisateurRerository;
		this.empruntRepository = empruntRepository;
	}

	@GetMapping("/")
	public String items(Model model,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue = "8") int size,
			@RequestParam(name="keyword", defaultValue = "") String keyword) {
		
		Page<Item> listItems = itemRepository.findAll(PageRequest.of(page, size));
		//List<Item> listItems = itemRepository.findByTitre(keyword);
		model.addAttribute("listItems", listItems.getContent());
		model.addAttribute("pages", new int[listItems.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", keyword);
		
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
	
	@GetMapping("/inscription")
	public String inscription (Model model) {
		return "/inscription";
	}
		
	@GetMapping("/user")
	public String user (@CurrentSecurityContext(expression = "authentication.principal") Model model, Principal principal) {

		//utilisateur connecté
		String utilisateurConnecte = principal.getName();
		Utilisateur utilisateur = utilisateurRerository.findByEmail(utilisateurConnecte);
		model.addAttribute("utilisateur", utilisateur);
		
		List<Emprunt> listEmprunts = empruntRepository.findEmpruntByUtilisateur(utilisateur);
		model.addAttribute("listEmprunts", listEmprunts);

		return "user";
	}
	
	@GetMapping("/faireEmprunt")
	public String createEmprunt(@CurrentSecurityContext(expression = "authentication.principal") Model model, Long id, Principal principal) {
		
		Item item = itemRepository.findById(id).orElse(null);
		
		Integer exemplaire = item.getNombreDExemplaires() - 1;
		item.setNombreDExemplaires(exemplaire);
		
		System.out.println();
		

		String utilisateurConnecte = principal.getName();
		Utilisateur utilisateur = utilisateurRerository.findByEmail(utilisateurConnecte);
		
		Emprunt emprunt = new Emprunt();
		emprunt.setUtilisateur(utilisateur);
		emprunt.setDateEmprunt(new Date());

		Set<Item> listItem = new HashSet<>();
		
		
		listItem.add(item);
		
		emprunt.setItems(listItem);
		
		empruntRepository.save(emprunt);
		
		return "redirect:/user";
		
	}
	
	@GetMapping("/restituer")
	public String restituer(Model model, Long id) {

		return "redirect:/user";
	}
	

	
//	@GetMapping("/logout")
//	public String logout (Model model) {
//		return "redirect:/";
//	}
	
		
	
}
