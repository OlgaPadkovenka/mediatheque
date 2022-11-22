package com.atos.mediatheque.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSequenceGenerator")
	@SequenceGenerator(name = "roleSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name="nom", unique = true)
	private String roleName;

	public RoleUser(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	
	public RoleUser() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleUser other = (RoleUser) obj;
		return Objects.equals(id, other.id) && Objects.equals(roleName, other.roleName);
	}

	@Override
	public String toString() {
		return "RoleUser [id=" + id + ", roleName=" + roleName + "]";
	}
	
	
}
