package com.example.repository;

import com.example.domain.comment.TranslatedComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TranslatedCommentRepository extends JpaRepository<TranslatedComment, Long> {
    List<TranslatedComment> findByOriginalCommentPostIdAndTargetLang(Long postId, String targetLang);
}
