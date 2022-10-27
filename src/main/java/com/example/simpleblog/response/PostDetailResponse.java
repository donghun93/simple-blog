package com.example.simpleblog.response;

import com.example.simpleblog.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostDetailResponse {

    private Long id;
    private String title;
    private String content;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @Builder
    private PostDetailResponse(Long id, String title, String content, String name, LocalDateTime createDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createDate = createDate;
    }

    public static PostDetailResponse of(Post post) {
        return PostDetailResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createDate(post.getCreateDate())
                .build();
    }
}
