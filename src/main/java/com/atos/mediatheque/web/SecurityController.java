//package com.atos.mediatheque.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.atos.mediatheque.entity.Utilisateur;
//import com.atos.mediatheque.repository.UtilisateurRerository;
//import com.atos.mediatheque.security.SecurityService;
//
//@Controller
//public class SecurityController {
//
//	@Autowired
//	private SecurityService securityService;
//
//	@Autowired
//	private UtilisateurRerository utilisateurRerository;
//
//	public SecurityController(SecurityService securityService, UtilisateurRerository utilisateurRerository) {
//		super();
//		this.securityService = securityService;
//		this.utilisateurRerository = utilisateurRerository;
//	}
//
//	@GetMapping("/register")
//	public String register (Model model, String email, String nom, String prenom, String motDePasse, String reMotDePasse) {
//		model.addAttribute("utilisateur", securityService.saveNewUser(email, nom, prenom, motDePasse, reMotDePasse));
//		return "register";
//	}	
//
//	@PostMapping("/saveUser")
//	public String saveUser(Model model, Utilisateur utilisateur) {
//		utilisateurRerository.save(utilisateur);
//		return "redirect:/";
//	}
//
//}
