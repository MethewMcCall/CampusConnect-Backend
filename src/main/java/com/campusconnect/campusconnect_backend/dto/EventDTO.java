package com.campusconnect.campusconnect_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private Long id;
    private String eventName;
    private String description;
    private LocalDateTime eventDate;
    private String location;
    private String organizer;
    private String eventCategory;
    private int maxAttendees;
    private boolean isPublic;
}
