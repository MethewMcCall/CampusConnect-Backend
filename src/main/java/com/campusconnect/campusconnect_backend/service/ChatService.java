package com.campusconnect.campusconnect_backend.service;

import com.campusconnect.campusconnect_backend.entity.Chat;
import com.campusconnect.campusconnect_backend.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat saveMessage(Chat chat) {
        return chatRepository.save(chat);
    }

    public List<Chat> getChatHistory(String senderId, String recipientId) {
        return chatRepository.findBySenderIdAndRecipientId(senderId, recipientId);
    }

    public List<Chat> getUnreadMessages(String recipientId) {
        return chatRepository.findByRecipientIdAndSeenFalse(recipientId);
    }

    public void markAsSeen(List<Chat> chats) {
        for (Chat chat : chats) {
            chat.setSeen(true);
        }
        chatRepository.saveAll(chats);
    }

    public Optional<Chat> getMessageById(Long id) {
        return chatRepository.findById(id);
    }
}
