package com.example.simpleblog.dto;

import com.example.simpleblog.domain.Member;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberListDto {
    private String name;
    private int age;

//    public MemberListDto(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public static MemberListDto of(Member member){
//        return new MemberListDto(member.getName(),member.getAge());
//    }


    public MemberListDto(Member member) {
    this.age=member.getAge();
    this.name=member.getName();

    }


}
