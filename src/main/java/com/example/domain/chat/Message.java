package com.example.domain.chat;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;

@EntityListeners(EntityListeners.class)
@Entity
@Getter
public class Message {

}
