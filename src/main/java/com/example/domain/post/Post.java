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
    private Long id;

    // ERD에 추가해야 함
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String originalText;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

//    @OneToOne(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private PostTranslation postTranslation;

    private User user;
}
