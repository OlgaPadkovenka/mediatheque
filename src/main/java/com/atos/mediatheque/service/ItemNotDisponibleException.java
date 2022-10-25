package com.atos.mediatheque.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotDisponibleException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ItemNotDisponibleException(String message) {
		super(message);
	}
}
