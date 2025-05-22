package com.example.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String originalText;
    private String category;
    private Long userId; // 작성자 ID (User 객체 매핑용)
}