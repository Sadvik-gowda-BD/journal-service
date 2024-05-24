package com.example.journalservice.service.impl;

import com.example.journalservice.dto.UserEventDto;
import com.example.journalservice.entity.UserEventEntity;
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
    public List<UserEventDto> getAllUserEvents() {
        return userEventRepository.findAll()
                .stream().map(eventEntity -> {
                    UserEventDto eventDto = new UserEventDto();
                    BeanUtils.copyProperties(eventEntity, eventDto);
                    return eventDto;
                }).toList();
    }

    @Override
    public void saveUserEvent(String event) {
        UserEventEntity eventEntity = UserEventEntity.builder()
                .eventDescription(event)
                .createdDateTime(LocalDateTime.now())
                .build();
        userEventRepository.save(eventEntity);
    }
}
