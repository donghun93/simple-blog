package com.example.simpleblog.exception;

import lombok.Getter;

@Getter
public class MemberException extends BlogException {

    public MemberException(MemberErrorCode errorCode) {
        super(errorCode.name(), errorCode.getDescription());
    }
}
