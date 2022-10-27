package com.example.simpleblog.exception;

import lombok.Getter;

@Getter
public class BlogException extends RuntimeException {

    private final String errorCode;
    private final String message;

    public BlogException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
