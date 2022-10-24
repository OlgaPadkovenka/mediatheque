package com.atos.mediatheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.repository.EmpruntRepository;

//@RestController
//@RequestMapping("/api/utilisateurs")
//public class EmpruntController {
//	
//	@Autowired
//	private EmpruntRepository empruntRepository;
//	
//	  @GetMapping
//	  public List<Emprunt> getAll() {
//		return empruntRepository.findAll();
//	  }
//	
//	  @GetMapping
//	  public Emprunt getOne(Long id) {
//		return empruntRepository.findById(id).get();
//	  }
//
//}
