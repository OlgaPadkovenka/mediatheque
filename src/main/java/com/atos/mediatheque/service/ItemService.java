package com.atos.mediatheque.service;



import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atos.mediatheque.dto.CDDto;
import com.atos.mediatheque.dto.OrikaConfig;
import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.repository.ItemRepository;

import ma.glasnost.orika.MapperFacade;

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
	
//	//save CD avec Orika Mapper
//	@Transactional
//	public CD saveCD(CD cd) {
//		itemRepository.save(cd);
//		return cd;
//	}
}
