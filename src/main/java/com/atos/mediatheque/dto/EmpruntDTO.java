package com.atos.mediatheque.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpruntDTO {
	
	private Long id;

	private Date dateEmprunt;

	private Date dateRetour;
	
	private List<CDDTO> cds = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public List<CDDTO> getCds() {
		return cds;
	}

	public void setCds(List<CDDTO> cds) {
		this.cds = cds;
	}

	
}
