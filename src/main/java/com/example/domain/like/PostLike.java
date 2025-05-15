package com.example.domain.like;

import com.example.domain.post.Post;
import com.example.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
public class PostLike {

    private User user;
    private Post post;

    @CreatedDate
    private LocalDateTime createdAt;

}
