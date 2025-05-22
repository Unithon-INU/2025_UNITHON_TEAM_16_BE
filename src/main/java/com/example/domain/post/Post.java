package com.example.domain.post;

import com.example.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    // ERD에 추가해야 함
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String originalText;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    // 번역된 게시글은 굳이 연관관계 필요없을 것 같음.
    // 서비스단에서 게시글 id랑 언어 id로 조회하는 게 훨씬 나을 것 같음.
}
