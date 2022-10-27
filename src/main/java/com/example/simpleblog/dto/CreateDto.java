package com.example.simpleblog.dto;

import lombok.Data;

@Data
public class CreateDto {
    private String email;
    private String name;
    private String address;
    private int age;
}
