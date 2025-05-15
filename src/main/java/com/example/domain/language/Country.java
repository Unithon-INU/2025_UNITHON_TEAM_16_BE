package com.example.domain.language;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Country {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;

    @Column(nullable = false)
    private String countryName;
}
