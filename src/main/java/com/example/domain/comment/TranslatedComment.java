package com.example.domain.comment;

import com.example.domain.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "UK_TRANSLATED_COMMENT_LANGUAGE",
                columnNames = {"commentId", "languageId"}
        )
)
public class TranslatedComment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long translatedCommentId;

    @Column(nullable = false)
    private String TranslatedText;

    private LocalDateTime translatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentId")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageId")
    private Language language;
}
