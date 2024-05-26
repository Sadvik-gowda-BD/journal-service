package com.example.journalservice.dto;

import lombok.Data;

@Data
public class UserEventResponseDto {
    private long eventId;
    private String eventDescription;
    private String createDateTime;
}
