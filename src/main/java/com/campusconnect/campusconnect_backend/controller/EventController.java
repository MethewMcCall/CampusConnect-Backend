package com.campusconnect.campusconnect_backend.controller;

import com.campusconnect.entity.Event;
import com.campusconnect.entity.EventCategory;
import com.campusconnect.entity.EventAttendee;
import com.campusconnect.campusconnect_backend.entity.User;
import com.campusconnect.service.EventService;
import com.campusconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    // Create a New Event
    @PostMapping("/create")
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.ok(createdEvent);
    }

    // Get All Events
    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    // Get Event By ID
    @GetMapping("/{eventId}")
    public ResponseEntity<?> getEventById(@PathVariable Long eventId) {
        Optional<Event> event = eventService.getEventById(eventId);
        if (event.isPresent()) {
            return ResponseEntity.ok(event.get());
        }
        return ResponseEntity.badRequest().body("Event not found");
    }

    // Update Event
    @PutMapping("/update/{eventId}")
    public ResponseEntity<?> updateEvent(@PathVariable Long eventId, @RequestBody Event updatedEvent) {
        Event event = eventService.updateEvent(eventId, updatedEvent);
        if (event != null) {
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.badRequest().body("Event not found or update failed");
    }

    // Delete Event
    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        boolean deleted = eventService.deleteEvent(eventId);
        if (deleted) {
            return ResponseEntity.ok("Event deleted successfully");
        }
        return ResponseEntity.badRequest().body("Event not found or delete failed");
    }

    //  Register User to Event (Attendee)
    @PostMapping("/{eventId}/register/{userId}")
    public ResponseEntity<?> registerUserToEvent(@PathVariable Long eventId, @PathVariable Long userId) {
        boolean registered = eventService.registerUserToEvent(eventId, userId);
        if (registered) {
            return ResponseEntity.ok("User successfully registered for the event.");
        }
        return ResponseEntity.badRequest().body("Event or User not found");
    }
}
