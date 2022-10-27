package com.example.simpleblog.domain;

import com.example.simpleblog.domain.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter
@Entity
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String email;
    private String name;
    private String address;

    @Builder
    private Member(String email, String name, String address, int age) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    private int age;
}


