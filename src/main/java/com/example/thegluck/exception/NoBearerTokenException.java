package com.example.thegluck.exception;

public class NoBearerTokenException extends Throwable {
    public NoBearerTokenException(String message) {
        super(message);
    }
}
