package com.campusconnect.campusconnect_backend.controller;

import com.campusconnect.campusconnect_backend.entity.ChatMessage;
import com.campusconnect.campusconnect_backend.service.ChatMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    public ChatMessageController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessageService.saveMessage(chatMessage);
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> getMessages(@PathVariable String senderId,
                                                         @PathVariable String recipientId) {
        List<ChatMessage> messages = chatMessageService.getChatHistory(senderId, recipientId);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/unread/{recipientId}")
    public ResponseEntity<List<ChatMessage>> getUnreadMessages(@PathVariable String recipientId) {
        List<ChatMessage> unreadMessages = chatMessageService.getUnreadMessages(recipientId);
        return ResponseEntity.ok(unreadMessages);
    }
}

