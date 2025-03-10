package com.campusconnect.campusconnect_backend.service;

import com.campusconnect.campusconnect_backend.entity.Poll;
import com.campusconnect.campusconnect_backend.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public void deletePoll(Long pollId) {
        pollRepository.deleteById(pollId);
    }
}
