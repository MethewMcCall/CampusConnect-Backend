package com.campusconnect.campusconnect_backend.controller;

import com.campusconnect.campusconnect_backend.dto.AuthResponse;
import com.campusconnect.campusconnect_backend.dto.LoginRequest;
import com.campusconnect.campusconnect_backend.dto.RegisterRequest;
import com.campusconnect.campusconnect_backend.entity.Role;
import com.campusconnect.campusconnect_backend.entity.User;
import com.campusconnect.campusconnect_backend.repository.RoleRepository;
import com.campusconnect.campusconnect_backend.repository.UserRepository;
import com.campusconnect.campusconnect_backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // User Registration
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already taken!");
        }

        // Create a new User
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Assigning ROLE_USER by default
        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = roleRepository.findByName("STUDENT");
        if (userRole.isPresent()) {
            roles.add(userRole.get());
        } else {
            Role role = new Role();
            role.setName("STUDENT");
            roleRepository.save(role);
            roles.add(role);
        }

        user.setRoles(roles);
        userRepository.save(user);

        // Generate JWT Token
        String token = jwtUtil.generateToken(user.getEmail());

        // Return response
        return ResponseEntity.ok(new AuthResponse(token, "User registered successfully"));
    }

    // User Login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if (user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            String token = jwtUtil.generateToken(user.get().getEmail());
            return ResponseEntity.ok(new AuthResponse(token, "Login successful"));
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
    }

    // Test API (to check JWT token is working)
    @GetMapping("/test")
    public String testEndpoint() {
        return "JWT Authentication is working!";
    }
}
