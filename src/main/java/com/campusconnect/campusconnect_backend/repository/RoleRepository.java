package com.campusconnect.campusconnect_backend.repository;

import com.campusconnect.campusconnect_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Find role by name (ADMIN, STUDENT, MODERATOR)
    Optional<Role> findByName(String name);
}
