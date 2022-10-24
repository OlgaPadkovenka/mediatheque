package com.atos.mediatheque.reposotiry;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.atos.mediatheque.controller.ItemController;
import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.repository.ItemRepository;


@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
	public ItemRepository itemRepository;
	public ItemController itemController;
	
	@Test
	public void creationCDTest() {
		CD cd = new CD();
		cd.setNom("CD nom test");
		cd.setNombreDExemplaires(4);
		cd.setTitre("CD titre test");
		cd.setDuree("125");
		cd.setDateDeParution(new Date(2003-12-02));
		itemRepository.save(cd);
	}
	
//	@Test
//	public void getItemsTest() {
//		List<Item> items = itemRepository.findAll();
//		assertEquals(1, items.size());
//
//	}
	
	
}
