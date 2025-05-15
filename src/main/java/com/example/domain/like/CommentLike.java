package com.example.domain.like;

import com.example.domain.comment.Comment;
import com.example.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
public class CommentLike {
    private User user;
    private Comment comment;

    @CreatedDate
    private LocalDateTime createdAt;
}
