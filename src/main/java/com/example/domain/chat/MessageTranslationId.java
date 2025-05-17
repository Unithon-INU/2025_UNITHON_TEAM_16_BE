package com.example.domain.chat;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageTranslationId implements Serializable {

    private Long messageId;

    @Column(length = 5)
    private String languageCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageTranslationId)) return false;
        MessageTranslationId that = (MessageTranslationId) o;
        return Objects.equals(messageId, that.messageId) &&
               Objects.equals(languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, languageCode);
    }
}
