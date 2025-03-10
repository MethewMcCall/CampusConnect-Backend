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
public class LostAndFoundDTO {
    private Long id;
    private String itemName;
    private String description;
    private String location;
    private Long userId;
    private LocalDateTime foundDate;
    private boolean isClaimed;
}
