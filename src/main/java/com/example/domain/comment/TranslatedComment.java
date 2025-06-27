package com.example.domain.comment;

import com.example.domain.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor
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
    private String translatedText;

    private LocalDateTime translatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentId")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageId")
    private Language language;

    public TranslatedComment(Comment comment, Language language, String translatedText) {
        this.comment = comment;
        this.language = language;
        this.translatedText = translatedText;
        this.translatedAt = LocalDateTime.now(); // 생성 시 시간 기록
    }
}
