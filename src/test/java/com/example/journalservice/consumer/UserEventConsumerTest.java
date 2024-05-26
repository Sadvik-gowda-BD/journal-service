package com.example.journalservice.consumer;

import com.example.journalservice.dto.EventDto;
import com.example.journalservice.service.UserEventService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.journalservice.contants.TestConstant.KEY;
import static com.example.journalservice.contants.TestConstant.MESSAGE_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserEventConsumerTest {

    @InjectMocks
    UserEventsConsumer userEventsConsumer;
    @Mock
    UserEventService userEventService;

    @Test
    void consumerUserEventsTest() {
        EventDto value = EventDto.builder()
                .message(MESSAGE_1)
                .build();
        ConsumerRecord<String, EventDto> consumerRecord = new ConsumerRecord<>("topic", 1,
                1, KEY, value);
        ArgumentCaptor<EventDto> eventDtoArgumentCaptor = ArgumentCaptor.forClass(EventDto.class);
        userEventsConsumer.consumerUserEvents(consumerRecord);

        verify(userEventService).saveUserEvent(eventDtoArgumentCaptor.capture());
        EventDto requestedValue = eventDtoArgumentCaptor.getValue();
        assertEquals(value, requestedValue);
    }
}
