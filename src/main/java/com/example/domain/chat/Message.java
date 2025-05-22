package com.example.domain.chat;

import com.example.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@EntityListeners(EntityListeners.class)
@Entity
@Getter
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column(nullable = false)
    private Long originalText;

    private LocalDateTime sentAt;

    @ManyToOne
    @JoinColumn(name = "conversation")
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
