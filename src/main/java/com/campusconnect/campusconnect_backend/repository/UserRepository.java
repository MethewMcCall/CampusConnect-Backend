package com.campusconnect.campusconnect_backend.repository;

import com.campusconnect.campusconnect_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email (for login)
    Optional<User> findByEmail(String email);

    // Check if email already exists
    boolean existsByEmail(String email);

    // Find user by name (optional, can be used for search)
    Optional<User> findByName(String name);

    // Find user by ID
    Optional<User> findById(Long id);
}
