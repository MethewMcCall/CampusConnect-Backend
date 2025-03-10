package com.campusconnect.campusconnect_backend.service;

import com.campusconnect.campusconnect_backend.entity.Vote;
import com.campusconnect.campusconnect_backend.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Vote castVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public void deleteVote(Long voteId) {
        voteRepository.deleteById(voteId);
    }
}
