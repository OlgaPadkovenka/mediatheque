package com.atos.mediatheque.dto;

import java.util.Date;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public abstract class ItemDto {
	
	private Long itemId;

	private String itemTitre;
	
	private Integer itemNombreDExemplaires;
	
	private Date itemDateDeParution;
	
	private String itemNom;
	
	

	public ItemDto() {
		super();
	}

	public ItemDto(Long itemId, String itemTitre,
			Integer itemNombreDExemplaires, Date itemDateDeParution,
			 String itemNom) {
		super();
		this.itemId = itemId;
		this.itemTitre = itemTitre;
		this.itemNombreDExemplaires = itemNombreDExemplaires;
		this.itemDateDeParution = itemDateDeParution;
		this.itemNom = itemNom;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemTitre() {
		return itemTitre;
	}

	public void setItemTitre(String itemTitre) {
		this.itemTitre = itemTitre;
	}

	public Integer getItemNombreDExemplaires() {
		return itemNombreDExemplaires;
	}

	public void setItemNombreDExemplaires(Integer itemNombreDExemplaires) {
		this.itemNombreDExemplaires = itemNombreDExemplaires;
	}

	public Date getItemDateDeParution() {
		return itemDateDeParution;
	}

	public void setItemDateDeParution(Date itemDateDeParution) {
		this.itemDateDeParution = itemDateDeParution;
	}

	public String getItemNom() {
		return itemNom;
	}

	public void setItemNom(String itemNom) {
		this.itemNom = itemNom;
	}

	@Override
	public String toString() {
		return "ItemDto [itemId=" + itemId + ", itemTitre=" + itemTitre + ", itemNombreDExemplaires="
				+ itemNombreDExemplaires + ", itemDateDeParution=" + itemDateDeParution + ", itemNom=" + itemNom + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemDateDeParution, itemId, itemNom, itemNombreDExemplaires, itemTitre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDto other = (ItemDto) obj;
		return Objects.equals(itemDateDeParution, other.itemDateDeParution) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(itemNom, other.itemNom)
				&& Objects.equals(itemNombreDExemplaires, other.itemNombreDExemplaires)
				&& Objects.equals(itemTitre, other.itemTitre);
	}


	
	

}
