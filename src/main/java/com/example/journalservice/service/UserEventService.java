package com.example.journalservice.service;

import com.example.journalservice.dto.UserEventResponseDto;

import java.util.List;


public interface UserEventService {

    public List<UserEventResponseDto> getAllUserEvents();

    public void saveUserEvent(String event);
}
