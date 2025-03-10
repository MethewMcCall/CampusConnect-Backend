package com.campusconnect.campusconnect_backend.service;

import com.campusconnect.campusconnect_backend.entity.Event;
import com.campusconnect.campusconnect_backend.entity.EventAttendee;
import com.campusconnect.campusconnect_backend.repository.EventAttendeeRepository;
import com.campusconnect.campusconnect_backend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventAttendeeService {

    @Autowired
    private EventAttendeeRepository eventAttendeeRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<EventAttendee> getAllAttendees(Long eventId) {
        return eventAttendeeRepository.findByEventId(eventId);
    }

    public EventAttendee registerAttendee(EventAttendee attendee, Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        attendee.setEvent(event);
        return eventAttendeeRepository.save(attendee);
    }

    public void deleteAttendee(Long attendeeId) {
        eventAttendeeRepository.deleteById(attendeeId);
    }
}

