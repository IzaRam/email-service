package com.iza.it.exception;

import java.util.NoSuchElementException;

public class EmailNotFoundException extends NoSuchElementException {
    public EmailNotFoundException(String message) {
        super(message);
    }
}
