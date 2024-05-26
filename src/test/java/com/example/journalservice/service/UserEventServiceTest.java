package com.example.journalservice.service;

import com.example.journalservice.dto.EventDto;
import com.example.journalservice.dto.UserEventResponseDto;
import com.example.journalservice.entity.UserEventEntity;
import com.example.journalservice.repository.UserEventRepository;
import com.example.journalservice.service.impl.UserEventServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.journalservice.contants.TestConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserEventServiceTest {

    @InjectMocks
    UserEventServiceImpl userEventService;
    @Mock
    UserEventRepository userEventRepository;

    @Test
    void getAllUserEvents() {

        UserEventEntity userEventEntity1 = UserEventEntity.builder()
                .eventDescription(MESSAGE_1)
                .createdDateTime(LOCAL_DATE_TIME_1)
                .build();
        UserEventEntity userEventEntity2 = UserEventEntity.builder()
                .eventDescription(MESSAGE_2)
                .createdDateTime(LOCAL_DATE_TIME_2)
                .build();
        when(userEventRepository.findAll()).thenReturn(List.of(userEventEntity1, userEventEntity2));
        List<UserEventResponseDto> response = userEventService.getAllUserEvents();

        UserEventResponseDto responseEntity1 = response.get(0);
        UserEventResponseDto responseEntity2 = response.get(1);
        assertEquals(2, response.size());
        assertEquals(MESSAGE_1, responseEntity1.getEventDescription());
        assertEquals(DATE_TIME_1, responseEntity1.getCreateDateTime());

        assertEquals(MESSAGE_2, responseEntity2.getEventDescription());
        assertEquals(DATE_TIME_2, responseEntity2.getCreateDateTime());
    }

    @Test
    void saveUserEventTest() {
        EventDto eventDto = EventDto.builder()
                .message(MESSAGE_1)
                .accessedBy(ACCESS_BY)
                .accessedFor(ACCESS_FOR)
                .build();

        ArgumentCaptor<UserEventEntity> entityArgumentCaptor = ArgumentCaptor.forClass(UserEventEntity.class);
        userEventService.saveUserEvent(eventDto);

        verify(userEventRepository, times(1)).save(entityArgumentCaptor.capture());
        UserEventEntity eventEntity = entityArgumentCaptor.getValue();

        assertEquals(eventDto.getMessage(), eventEntity.getEventDescription());
        assertEquals(eventDto.getAccessedBy(), eventEntity.getAccessedBy());
        assertEquals(eventDto.getAccessedFor(), eventEntity.getAccessedFor());
        assertNotNull(eventEntity.getCreatedDateTime());
    }
}
