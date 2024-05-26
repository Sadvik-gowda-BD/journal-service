package com.example.journalservice.service;

import com.example.journalservice.dto.EventDto;
import com.example.journalservice.dto.UserEventResponseDto;

import java.util.List;


public interface UserEventService {

    public List<UserEventResponseDto> getAllUserEvents();

    public void saveUserEvent(EventDto event);
}
