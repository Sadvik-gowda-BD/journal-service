package com.example.journalservice.controller;

import com.example.journalservice.dto.UserEventResponseDto;
import com.example.journalservice.service.UserEventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.example.journalservice.contants.TestConstant.MESSAGE_1;
import static com.example.journalservice.contants.TestConstant.MESSAGE_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserEventControllerTest {

    @InjectMocks
    UserEventController userEventController;
    @Mock
    UserEventService userEventService;

    @Test
    public void getAllUserEventsTest() {
        UserEventResponseDto eventResponseDto1 = UserEventResponseDto.builder()
                .eventDescription(MESSAGE_1)
                .build();
        UserEventResponseDto eventResponseDto2 = UserEventResponseDto.builder()
                .eventDescription(MESSAGE_2)
                .build();

        when(userEventService.getAllUserEvents()).thenReturn(List.of(eventResponseDto1, eventResponseDto2));
        ResponseEntity<List<UserEventResponseDto>> responseEntity = userEventController.getAllUserEvents();
        List<UserEventResponseDto> response = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(response);
        assertEquals(2, response.size());
    }

}
