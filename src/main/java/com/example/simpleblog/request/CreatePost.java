package com.example.simpleblog.request;

import com.example.simpleblog.domain.Member;
import com.example.simpleblog.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreatePost {

    private String title;
    private String content;

    public Post toEntity(Member member) {
        return Post.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}
