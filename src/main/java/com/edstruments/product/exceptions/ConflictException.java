package com.edstruments.product.exceptions;

public class ConflictException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ConflictException(String message) {
        super(message);
    }
}
