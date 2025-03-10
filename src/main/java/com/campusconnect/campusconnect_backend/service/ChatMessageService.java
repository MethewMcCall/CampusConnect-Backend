package com.campusconnect.campusconnect_backend.service;

import com.campusconnect.campusconnect_backend.entity.ChatMessage;
import com.campusconnect.campusconnect_backend.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessage saveMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> getChatHistory(String senderId, String recipientId) {
        return chatMessageRepository.findBySenderIdAndRecipientId(senderId, recipientId);
    }

    public List<ChatMessage> getUnreadMessages(String recipientId) {
        return chatMessageRepository.findByRecipientIdAndSeenFalse(recipientId);
    }

    public Optional<ChatMessage> getMessageById(Long id) {
        return chatMessageRepository.findById(id);
    }
}
