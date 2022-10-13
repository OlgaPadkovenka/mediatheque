package com.atos.mediatheque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.repository.ItemRepository;

@Service
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	
	//Methode pour récupérer tous les items sans DTO
	public List<Item> getAll() {
		List<Item> allItems = itemRepository.findAll();
		return allItems;
	}
	
}
