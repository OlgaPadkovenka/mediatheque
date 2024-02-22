package com.atos.mediatheque.web;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.entity.DVD;
import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.entity.Livre;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.ItemRepository;
import com.atos.mediatheque.repository.UtilisateurRerository;
import com.atos.mediatheque.security.SecurityService;
import com.atos.mediatheque.service.EmpruntService;
import com.atos.mediatheque.service.ItemService;


@RestController
public class WebController {

	@Autowired
	private ItemRepository itemRepository;
	
	private UtilisateurRerository utilisateurRerository;
	
	private EmpruntRepository empruntRepository;
	
	private EmpruntService empruntService;
	
	private ItemService itemService;
	
	public WebController(ItemRepository itemRepository, UtilisateurRerository utilisateurRerository,
			EmpruntRepository empruntRepository, EmpruntService empruntService, ItemService itemService) throws BeanCreationException {
		super();
		this.itemRepository = itemRepository;
		this.utilisateurRerository = utilisateurRerository;
		this.empruntRepository = empruntRepository;
		this.empruntService = empruntService;
		this.itemService = itemService;
	}

//	@GetMapping("/")
//	public String items(Model model) {
//		List<Item> listItems = itemRepository.findAll();
//		model.addAttribute("listItems", listItems);		
//		return "index";
//	}
	
/*	@GetMapping("/")
	public String getAllPages(Model model) {
		//List<Item> listItems = itemRepository.findAll();
		return itemsOnePage(model, 1);
	}
	*/
	
    @GetMapping("/")
    public List<Item> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }
	
	@GetMapping("/page/{pageNumber}")
	public String itemsOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		
		//Page<Item> page = itemService.findPage(currentPage, keyword);

			Page<Item> page = itemService.findPage(currentPage);
			int totalPages = page.getTotalPages();
			long totalItems = page.getTotalElements(); 
			
			List<Item> listItems = page.getContent();
						
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", totalPages);	
			model.addAttribute("totalItems", totalItems);
			model.addAttribute("listItems", listItems);	
	
		return "index";
	}
	
//	@GetMapping("/search")
//	public String search(Model model, String keyword) {
//		if(keyword != null) {
//			model.addAttribute("listItems", itemService.findByKeyword(keyword) );
//		} else {
//			model.addAttribute("listItems", itemRepository.findAll());
//		}
//		return "search";  
//	}
	
	@GetMapping("/search")
	public String search(Model model, String keyword) {
			model.addAttribute("listItems", itemRepository.findAll());
		return "search";  
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
		//itemRepository.save(itemService.saveCD());
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
		
	@GetMapping("/user")
	public String user (@CurrentSecurityContext(expression = "authentication.principal") Model model, Principal principal) {

		//utilisateur connecté
		String utilisateurConnecte = principal.getName();
		Utilisateur utilisateur = utilisateurRerository.findByEmail(utilisateurConnecte);
		model.addAttribute("utilisateur", utilisateur);
		
		//Liste des emprunts
		List<Emprunt> listEmprunts = empruntRepository.findEmpruntByUtilisateur(utilisateur);
		model.addAttribute("listEmprunts", listEmprunts);
		
		//Historique
		List<Emprunt> listHistoriqueEmprunts = empruntRepository.findHistoriqueEmpruntByUtilisateur(utilisateur);
		model.addAttribute("listHistoriqueEmprunts", listHistoriqueEmprunts);
		
		return "user";
	}
	
	@GetMapping("/faireEmprunt")
	public String createEmprunt(@CurrentSecurityContext(expression = "authentication.principal") Model model, Long id, Principal principal) {
				
		empruntService.faireEmprunt(model, id, principal);

		return "redirect:/user";
		
	}
	
	@GetMapping("/restituer")
	public String restituerEmprunt(@CurrentSecurityContext(expression = "authentication.principal") Model model, Long id, Principal principal) {

		
		Emprunt emprunt = empruntRepository.findById(id).orElse(null);
		Date dateRetour = new Date();
		emprunt.setDateRetour(dateRetour);

		//item.getNombreDExemplaires() + 1; ne marche pas
				
//		Item item = itemRepository.findById(id).orElse(null);
//		
//		Integer exemplaire = item.getNombreDExemplaires() + 1;
//		item.setNombreDExemplaires(exemplaire);
//	
//		Set<Item> listItem = emprunt.getItems();
//		
//		listItem.add(item);
//		
//		emprunt.setItems(listItem);
		
		empruntRepository.save(emprunt);
		
		return "redirect:/user";
	}
		
}
