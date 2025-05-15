package com.example.domain.chat;

import com.example.domain.chat.Conversation;
import com.example.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;

@Entity
@Getter
public class Message {

    private Long messageId;
    private String originalText;
    private LocalDateTime createdAt;
    private Conversation converstation;
    private User user;
}
