package com.campusconnect.campusconnect_backend.service;

import com.campusconnect.campusconnect_backend.entity.Event;
import com.campusconnect.campusconnect_backend.entity.EventAttendee;
import com.campusconnect.campusconnect_backend.entity.User;
import com.campusconnect.campusconnect_backend.repository.EventRepository;
import com.campusconnect.campusconnect_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    // Create Event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Get All Events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get Event By ID
    public Optional<Event> getEventById(Long eventId) {
        return eventRepository.findById(eventId);
    }

    // Update Event
    public Event updateEvent(Long eventId, Event updatedEvent) {
        Optional<Event> existingEvent = eventRepository.findById(eventId);
        if (existingEvent.isPresent()) {
            Event event = existingEvent.get();
            event.setTitle(updatedEvent.getTitle());
            event.setDescription(updatedEvent.getDescription());
            event.setDate(updatedEvent.getDate());
            return eventRepository.save(event);
        }
        return null;
    }

    // Delete Event
    public boolean deleteEvent(Long eventId) {
        if (eventRepository.existsById(eventId)) {
            eventRepository.deleteById(eventId);
            return true;
        }
        return false;
    }

    // Register User To Event
    public boolean registerUserToEvent(Long eventId, Long userId) {
        Optional<Event> event = eventRepository.findById(eventId);
        Optional<User> user = userRepository.findById(userId);

        if (event.isPresent() && user.isPresent()) {
            EventAttendee attendee = new EventAttendee();
            attendee.setEvent(event.get());
            attendee.setUser(user.get());
            event.get().getAttendees().add(attendee);
            eventRepository.save(event.get());
            return true;
        }
        return false;
    }
}

