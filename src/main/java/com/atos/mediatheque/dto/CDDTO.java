package com.atos.mediatheque.dto;

import java.util.Objects;

public class CDDTO extends ItemDTO{

	private String duree;

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duree);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CDDTO other = (CDDTO) obj;
		return Objects.equals(duree, other.duree);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CDDTO [duree=");
		builder.append(duree);
		builder.append("]");
		return builder.toString();
	}
	
}
