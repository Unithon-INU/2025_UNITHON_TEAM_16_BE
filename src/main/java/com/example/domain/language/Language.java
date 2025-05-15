package com.example.domain.language;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Language {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;

    @Column(nullable = false, unique = true)
    private String languageName;

}
