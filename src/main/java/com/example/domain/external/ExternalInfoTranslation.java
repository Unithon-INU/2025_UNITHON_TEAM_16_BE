package com.example.domain.external;

import com.example.domain.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "external_info_translation")
@Getter
@NoArgsConstructor
public class ExternalInfoTranslation {

    @EmbeddedId
    private ExternalInfoTranslationId id;

    @MapsId("infoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_id", nullable = false)
    private ExternalInfo externalInfo;

    @MapsId("langCode")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lang_code", nullable = false)
    private Language language;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String translatedText;

    @Column(nullable = false)
    private LocalDateTime translatedAt;

}
