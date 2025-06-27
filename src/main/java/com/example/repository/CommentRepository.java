package com.example.repository;

import com.example.domain.comment.Comment;
import com.example.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);

    List<Comment> findByPost(Post post);
}
