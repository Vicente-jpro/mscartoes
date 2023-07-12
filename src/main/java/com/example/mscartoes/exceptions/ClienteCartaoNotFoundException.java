package com.example.mscartoes.exceptions;

public class ClienteCartaoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteCartaoNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
