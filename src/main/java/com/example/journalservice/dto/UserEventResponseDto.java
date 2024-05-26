package com.example.journalservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEventResponseDto {
    private long eventId;
    private String eventDescription;
    private String accessedBy;
    private String accessedFor;
    private String createDateTime;
}
