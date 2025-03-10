package com.campusconnect.campusconnect_backend.repository;

import com.campusconnect.campusconnect_backend.entity.LostAndFound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LostAndFoundRepository extends JpaRepository<LostAndFound, Long> {
    List<LostAndFound> findByStatus(String status);
    List<LostAndFound> findByUserId(Long userId);
}
