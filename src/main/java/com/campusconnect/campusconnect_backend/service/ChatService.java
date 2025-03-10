package com.campusconnect.campusconnect_backend.service;

import com.campusconnect.campusconnect_backend.entity.Chat;
import com.campusconnect.campusconnect_backend.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public List<Chat> getAllMessages() {
        return chatRepository.findAll();
    }

    public Optional<Chat> getMessageById(Long messageId) {
        return chatRepository.findById(messageId);
    }

    public Chat sendMessage(Chat chat) {
        return chatRepository.save(chat);
    }

    public void deleteMessage(Long messageId) {
        chatRepository.deleteById(messageId);
    }
}
