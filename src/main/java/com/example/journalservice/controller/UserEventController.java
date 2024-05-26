package com.example.journalservice.controller;

import com.example.journalservice.dto.UserEventResponseDto;
import com.example.journalservice.repository.UserCredentialRepo;
import com.example.journalservice.service.UserEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserEventController {

    private final UserEventService userEventService;

    @Autowired
    UserCredentialRepo userCredentialRepo;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public List<UserEventResponseDto> getAllUserEvents() {
        return userEventService.getAllUserEvents();
    }

}
