package com.example.journalservice.service.impl;

import com.example.journalservice.dto.EventDto;
import com.example.journalservice.dto.UserEventResponseDto;
import com.example.journalservice.entity.UserEventEntity;
import com.example.journalservice.mapper.UserEventMapper;
import com.example.journalservice.repository.UserEventRepository;
import com.example.journalservice.service.UserEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserEventServiceImpl implements UserEventService {

    private final UserEventRepository userEventRepository;

    @Override
    public List<UserEventResponseDto> getAllUserEvents() {
        return userEventRepository.findAll()
                .stream().map(UserEventMapper::map).toList();
    }

    @Override
    public void saveUserEvent(EventDto event) {
        UserEventEntity eventEntity = UserEventEntity.builder()
                .accessedBy(event.getAccessedBy())
                .accessedFor(event.getAccessedFor())
                .eventDescription(event.getMessage())
                .createdDateTime(LocalDateTime.now())
                .build();
        userEventRepository.save(eventEntity);
    }
}
