package com.atos.mediatheque.dto;

import com.atos.mediatheque.entity.CD;
import com.atos.mediatheque.entity.Item;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaConfig extends ConfigurableMapper{
	
	public MapperFacade mapper(final MapperFactory mapperFactory) {
		return mapperFactory.getMapperFacade();
	}

	public MapperFactory mapperFactoryItem() {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		
		mapperFactory.classMap(Item.class, ItemDto.class)
		.field("id", "itemId")
		.field("titre", "itemTitre")
		.field("nombreDExemplaires", "itemNombreDExemplaires")
		.field("dateDeParution", "itemDateDeParution")
		.field("nom", "itemNom")
		.byDefault()
		.register();
		return mapperFactory;
		
	}
	
	public MapperFactory mapperFactoryCD() {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		
		mapperFactory.classMap(CD.class, CDDto.class)
		.field("duree", "cdDuree")
		.byDefault()
		.register();
		return mapperFactory;
		
	}
	
}
