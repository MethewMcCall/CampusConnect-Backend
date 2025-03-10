package com.campusconnect.campusconnect_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderId;
    private String receiverId;
    private String content;
    private LocalDateTime timestamp;
    private boolean seen;

    public ChatMessage() {
        this.timestamp = LocalDateTime.now();
        this.seen = false;
    }

}
