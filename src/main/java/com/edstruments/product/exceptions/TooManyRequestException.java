package com.edstruments.product.exceptions;

public class TooManyRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TooManyRequestException(String message) {
        super(message);
    }
}
