package com.campusconnect.campusconnect_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderId;
    private String recipientId;
    private String content;
    private LocalDateTime timestamp;
    private boolean seen;

    public Chat() {
        this.timestamp = LocalDateTime.now();
        this.seen = false;
    }

    // Getters and Setters

}
