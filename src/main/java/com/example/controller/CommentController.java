package com.example.controller;

import com.example.domain.comment.Comment;
import com.example.dto.CommentRequestDto;
import com.example.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/post/{postId}")
    public List<Comment> getComments(@PathVariable Long postId) {
        return commentService.getComments(postId);
    }

    @PostMapping("/post/{postId}")
    public Comment addComment(@PathVariable Long postId,
                              @RequestBody CommentRequestDto request) {
        return commentService.createComment(postId, request.userId, request.content);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}