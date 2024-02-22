package com.atos.mediatheque.dto;

import java.util.Objects;

public class CDDto extends ItemDto{
	
	private String cdDuree;
	
	public CDDto() {
		super();
	}
	

	public CDDto(String cdDuree) {
		super();
		this.cdDuree = cdDuree;
	}



	public String getCdDuree() {
		return cdDuree;
	}

	public void setCdDuree(String cdDuree) {
		this.cdDuree = cdDuree;
	}


	@Override
	public String toString() {
		return "CDDto [cdDuree=" + cdDuree + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cdDuree);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CDDto other = (CDDto) obj;
		return Objects.equals(cdDuree, other.cdDuree);
	}
	

	
}
