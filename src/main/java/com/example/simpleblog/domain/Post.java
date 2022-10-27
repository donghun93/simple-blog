package com.example.simpleblog.domain;

import com.example.simpleblog.domain.common.BaseEntity;
import com.example.simpleblog.exception.PostException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    @Lob
    private String content;

    private Boolean deleteYn;
    private LocalDateTime deletedDate;

    @Builder
    private Post(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.deleteYn = false;
    }

    public void delete() {
        if(!this.deleteYn) {
            this.deleteYn = true;
            this.deletedDate = LocalDateTime.now();
        }
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
