package com.campusconnect.campusconnect_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "polls")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @ElementCollection
    private List<String> options;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User createdBy;

    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}
