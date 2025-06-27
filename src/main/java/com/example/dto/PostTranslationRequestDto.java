package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostTranslationRequestDto {
    private String title;
    private String originalText;
    private List<String> comments;
}
