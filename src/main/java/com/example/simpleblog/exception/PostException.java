package com.example.simpleblog.exception;

import lombok.Getter;

@Getter
public class PostException extends BlogException {

    public PostException(PostErrorCode errorCode) {
        super(errorCode.name(), errorCode.getDescription());
    }
}
