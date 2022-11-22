package com.atos.mediatheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//get et set lombok
@Data
//constructeur avec arguments
@AllArgsConstructor
//constructeur sans argument
@NoArgsConstructor
@Table(name="role")
public class RoleUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSequenceGenerator")
	@SequenceGenerator(name = "roleSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name="nom")
	private String roleName;
	
	
}
