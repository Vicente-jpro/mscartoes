package com.example.mscartoes.exceptions;

public class CartaoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CartaoNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
