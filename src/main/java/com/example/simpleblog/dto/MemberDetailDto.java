package com.example.simpleblog.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberDetailDto {
    private String email;
    private String name;
    private String address;
    private int age;
}
