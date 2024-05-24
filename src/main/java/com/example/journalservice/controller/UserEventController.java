package com.example.journalservice.controller;

import com.example.journalservice.dto.UserEventDto;
import com.example.journalservice.service.UserEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserEventController {

    private final UserEventService userEventService;

    @GetMapping("/all")
    public List<UserEventDto> getAllUserEvents() {
        return userEventService.getAllUserEvents();
    }

    @GetMapping("/test")
    public String test() {
        return "test endpoint";
    }
}
