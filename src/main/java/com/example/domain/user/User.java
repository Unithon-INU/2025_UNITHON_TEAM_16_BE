package com.example.domain.user;

import com.example.domain.language.Country;
import com.example.domain.language.Language;
import com.example.domain.post.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nickname;

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




}
