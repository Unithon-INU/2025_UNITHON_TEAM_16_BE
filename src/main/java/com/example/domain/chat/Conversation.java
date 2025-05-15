package com.example.domain.chat;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
public class Conversation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conversationId;

    @CreatedDate
    private LocalDateTime createdAt;
}
