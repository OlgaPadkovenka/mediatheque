package com.atos.mediatheque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.repository.ItemRepository;

@Controller
public class WebController {
	
	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/")
	public String index(Model model) {
		List<Item> listItems = itemRepository.findAll();
		model.addAttribute("listItems", listItems);
		return "index";
	}
	
	@GetMapping("/items")
	public String items() {
		return "items";
	}
}
