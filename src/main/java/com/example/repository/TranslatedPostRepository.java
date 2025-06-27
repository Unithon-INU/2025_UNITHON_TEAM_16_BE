package com.example.repository;

import com.example.domain.post.TranslatedPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TranslatedPostRepository extends JpaRepository<TranslatedPost, Long> {
    Optional<TranslatedPost> findByOriginalPostIdAndTargetLang(Long originalPostId, String targetLang);
}
