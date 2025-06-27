package com.example.dto;

import lombok.Getter;

@Getter
public class PostUpdateRequestDto {
    private String title;
    private String originalText;
    private String category;
}