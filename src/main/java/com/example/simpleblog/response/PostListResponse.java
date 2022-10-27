package com.example.simpleblog.response;

import com.example.simpleblog.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostListResponse {

    private Long id;
    private String title;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @Builder
    private PostListResponse(Long id, String title, String name, LocalDateTime createDate) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.createDate = createDate;
    }

    public static PostListResponse of(Post post) {
        return PostListResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .createDate(post.getCreateDate())
                .build();
    }
}
