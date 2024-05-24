package com.example.journalservice.service;

import com.example.journalservice.dto.UserEventDto;

import java.util.List;


public interface UserEventService {

    public List<UserEventDto> getAllUserEvents();

    public void saveUserEvent(String event);
}
