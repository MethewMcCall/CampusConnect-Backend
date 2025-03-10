package com.campusconnect.campusconnect_backend.service;

import com.campusconnect.campusconnect_backend.entity.LostAndFound;
import com.campusconnect.campusconnect_backend.repository.LostAndFoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostAndFoundService {

    @Autowired
    private LostAndFoundRepository lostAndFoundRepository;

    public List<LostAndFound> getAllItems() {
        return lostAndFoundRepository.findAll();
    }

    public LostAndFound reportItem(LostAndFound item) {
        return lostAndFoundRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        lostAndFoundRepository.deleteById(itemId);
    }
}
