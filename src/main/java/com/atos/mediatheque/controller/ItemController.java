package com.atos.mediatheque.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	private ItemService itemService;
	
	private ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	//Mapping sans DTO
	  @GetMapping
	  public ResponseEntity<List<Item>> getAll() { 
		  List<Item> allItems = itemService.getAll();
		  return ResponseEntity.ok(allItems);
	  }
	
	
}
