package com.example.simpleblog.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdatePost {

    private String title;
    private String content;
}
