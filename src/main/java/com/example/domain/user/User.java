package com.example.domain.user;

import com.example.domain.language.Country;
import com.example.domain.language.Language;
import com.example.domain.post.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "postId")
    private List<Post> posts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "languageId")
    private Language language;

    @OneToOne
    @JoinColumn(name = "countryId")
    private Country country;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;





}
