package com.example.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostTranslationResponseDto {
    private String title;
    private String translatedText;
    private List<String> comments;
}
