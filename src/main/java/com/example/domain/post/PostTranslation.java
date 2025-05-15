package com.example.domain.post;

import com.example.domain.language.Language;
import com.example.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class PostTranslation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ERD에 추가해야함
    @Column(nullable = false)
    private String translatedTitle;

    @Column(nullable = false)
    private String translatedText;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "postId")
//    private Post post;

    private Language language;
}
