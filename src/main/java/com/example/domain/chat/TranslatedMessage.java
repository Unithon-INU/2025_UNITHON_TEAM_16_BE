package com.example.domain.chat;

import com.example.domain.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Table(
        uniqueConstraints =
        @UniqueConstraint(
                name = "UK_TRANSLATED_MESSAGE_LANGUAGE",
                columnNames = {"messageId", "languageId"})
)
public class TranslatedMessage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long translatedMessageId;

    private LocalDateTime translatedAt;

    @Column(nullable = false)
    private String translatedText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "messageId")
    private Message message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageId")
    private Language language;
}
