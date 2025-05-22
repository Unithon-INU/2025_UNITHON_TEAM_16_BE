package com.example.domain.chat;

import com.example.domain.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "message_translation", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"message_id", "language_code"})
})
public class MessageTranslation {

    @EmbeddedId
    private MessageTranslationId id;

    @MapsId("messageId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id", nullable = false)
    private Message message;

    @MapsId("languageCode")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_code", nullable = false)
    private Language language;

    @Column(name = "translated_text", nullable = false, columnDefinition = "TEXT")
    private String translatedText;
}
