package com.atos.mediatheque.reposotiry;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.atos.mediatheque.entity.Item;
import com.atos.mediatheque.repository.ItemRepository;


@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
	public ItemRepository itemRepository;
		
	@Test
	public void getCDsTest() {
		List<Item> items = itemRepository.findAllCd();
		assertEquals(5, items.size());
	}
	
	@Test
	public void getDVDsTest() {
		List<Item> items = itemRepository.findAllDvd();
		assertEquals(5, items.size());
	}
	
	@Test
	public void getLivresTest() {
		List<Item> items = itemRepository.findAllLivre();
		assertEquals(5, items.size());
	}
	
}
