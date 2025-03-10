package com.campusconnect.campusconnect_backend.controller;

import com.campusconnect.campusconnect_backend.entity.LostAndFound;
import com.campusconnect.campusconnect_backend.service.LostAndFoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lost-and-found")
@RequiredArgsConstructor
public class LostAndFoundController {

    private final LostAndFoundService lostAndFoundService;

    @PostMapping("/report")
    public ResponseEntity<LostAndFound> reportItem(@RequestBody LostAndFound item) {
        return ResponseEntity.ok(lostAndFoundService.reportItem(item));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LostAndFound>> getAllItems() {
        return ResponseEntity.ok(lostAndFoundService.getAllItems());
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<LostAndFound> getItemById(@PathVariable Long itemId) {
        return ResponseEntity.ok(lostAndFoundService.getItemById(itemId));
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        lostAndFoundService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }
}
