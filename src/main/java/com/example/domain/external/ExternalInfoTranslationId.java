package com.example.domain.external;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExternalInfoTranslationId implements Serializable {

    private Long infoId;

    @Column(length = 5)
    private String langCode;
}