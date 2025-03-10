package com.campusconnect.campusconnect_backend.repository;

import com.campusconnect.campusconnect_backend.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findBySenderIdAndRecipientId(String senderId, String recipientId);

    List<Chat> findByRecipientIdAndSeenFalse(String recipientId);
}
