package com.atos.mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.mediatheque.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
