package com.example.service;

import com.example.domain.comment.Comment;
import com.example.domain.post.Post;
import com.example.domain.user.User;
import com.example.repository.CommentRepository;
import com.example.repository.PostRepository;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepo;
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public List<Comment> getComments(Long postId) {
        Post post = postRepo.findById(postId).orElseThrow();
        return commentRepo.findByPost(post);
    }

    public Comment createComment(Long postId, Long userId, String content) {
        Post post = postRepo.findById(postId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();
        Comment comment = Comment.builder()
                .post(post)
                .user(user)
                .originalText(content)
                .createdAt(LocalDateTime.now())
                .build();
        return commentRepo.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepo.deleteById(commentId);
    }
}