package com.example.simpleblog.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PostErrorCode {

    POST_NOT_FOUND("게시글이 존재하지 않습니다.")
    ;

    private final String description;
}
