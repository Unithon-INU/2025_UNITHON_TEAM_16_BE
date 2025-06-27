package com.example.dto;

import lombok.Getter;

@Getter
public class PostListResponseDto {
    private final Long id;
    private final String title;
    private final String category;
    private final String authorName;

    public PostListResponseDto(Long id, String title, String category, String authorName) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.authorName = authorName;
    }
}
