package com.example.journalservice.consumer;

import com.example.journalservice.dto.EventDto;
import com.example.journalservice.service.UserEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserEventsConsumer {

    final String userEventTopic = "user-events";
    private final UserEventService userEventService;

    @KafkaListener(topics = userEventTopic)
    public void consumerUserEvents(ConsumerRecord<String, EventDto> consumerRecord) {
        log.info("Consumed message - key:{} ,value:{}", consumerRecord.key(), consumerRecord.value());
        EventDto val = consumerRecord.value();
//        userEventService.saveUserEvent(consumerRecord.value());
    }
}
