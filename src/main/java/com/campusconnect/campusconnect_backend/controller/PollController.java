package com.campusconnect.campusconnect_backend.controller;

import com.campusconnect.campusconnect_backend.entity.Poll;
import com.campusconnect.campusconnect_backend.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;

    @PostMapping("/create")
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        return ResponseEntity.ok(pollService.createPoll(poll));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Poll>> getAllPolls() {
        return ResponseEntity.ok(pollService.getAllPolls());
    }

    @PostMapping("/vote/{pollId}/{userId}")
    public ResponseEntity<Void> castVote(@PathVariable Long pollId, @PathVariable Long userId) {
        pollService.castVote(pollId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{pollId}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long pollId) {
        return ResponseEntity.ok(pollService.getPollById(pollId));
    }

    @DeleteMapping("/delete/{pollId}")
    public ResponseEntity<Void> deletePoll(@PathVariable Long pollId) {
        pollService.deletePoll(pollId);
        return ResponseEntity.noContent().build();
    }
}
