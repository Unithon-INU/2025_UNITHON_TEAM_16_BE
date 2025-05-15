package com.example.domain.comment;

import com.example.domain.language.Language;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CommentTranslated {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CommentTranslatedId;

    @Column(nullable = false)
    private String TranslatedText;

    private Comment comment;
    private Language language;
}
