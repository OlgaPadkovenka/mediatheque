package com.atos.mediatheque.service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.repository.ItemRepository;

@Service
public class ItemService {
	
	private ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}
	
	public Page<Item> findPage(int pageNumber) {
		Pageable pegeable = PageRequest.of(pageNumber -1, 6);
		  
		return itemRepository.findAll(pegeable);
		//return itemRepository.findByNomContains(keyword, pegeable);
	}
	
	public List<Item> findByKeyword(String keyword) {
		return itemRepository.findByKeyword(keyword);
		
	}
}
