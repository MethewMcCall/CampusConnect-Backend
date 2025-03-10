package com.campusconnect.campusconnect_backend.controller;

import com.campusconnect.campusconnect_backend.entity.Chat;
import com.campusconnect.campusconnect_backend.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody Chat chat) {
        Chat savedMessage = chatService.saveMessage(chat);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping("/messages/{senderId}/{receiverId}")
    public ResponseEntity<List<Chat>> getMessages(@PathVariable String senderId,
                                                  @PathVariable String receiverId) {
        List<Chat> messages = chatService.getChatHistory(senderId, receiverId);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/unread/{receiverId}")
    public ResponseEntity<List<Chat>> getUnreadMessages(@PathVariable String receiverId) {
        List<Chat> unreadMessages = chatService.getUnreadMessages(receiverId);
        return ResponseEntity.ok(unreadMessages);
    }

    @PutMapping("/mark-seen/{receiverId}")
    public ResponseEntity<?> markMessagesAsSeen(@PathVariable String receiverId) {
        List<Chat> unreadMessages = chatService.getUnreadMessages(receiverId);
        chatService.markAsSeen(unreadMessages);
        return ResponseEntity.ok("Messages marked as seen.");
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable Long id) {
        Optional<Chat> message = chatService.getMessageById(id);
        return message.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
