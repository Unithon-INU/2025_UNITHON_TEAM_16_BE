package com.example.dto;

import lombok.Getter;

@Getter
public class PostResponseDto {
    private final Long id;
    private final String title;
    private final String originalText;
    private final String category;
    private final String authorName; // 작성자 이름

    public PostResponseDto(Long id, String title, String originalText, String category, String authorName) {
        this.id = id;
        this.title = title;
        this.originalText = originalText;
        this.category = category;
        this.authorName = authorName;
    }
}
