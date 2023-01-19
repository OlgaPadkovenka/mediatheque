package com.atos.mediatheque.web;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.security.SecurityService;

@Controller
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	public SecurityController(SecurityService securityService) {
		super();
		this.securityService = securityService;
	}
	
	@GetMapping("/register")
	public String register (Model model, @ModelAttribute("utilisateur") Utilisateur utilisateur) {
		model.addAttribute("utilisateur");
		return "register";
	}	
	
	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult result, Model model, String email, String nom, String prenom, String motDePasse, String reMotDePasse) {

		if(result.hasErrors()) {
			return "register";
		}
		securityService.saveNewUser(email, nom, prenom, motDePasse, reMotDePasse);
		securityService.addRoleToUser(email, "USER");
		return "redirect:/login";
	}

}
