package com.example.domain.post;

import com.example.domain.language.Language;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class TranslatedPost {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long translatedMessageId;

    // ERD에 추가해야함
    @Column(nullable = false)
    private String translatedTitle;

    @Column(nullable = false)
    private String translatedText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageId")
    private Language language;
}
