package com.example.journalservice.mapper;

import com.example.journalservice.dto.UserEventResponseDto;
import com.example.journalservice.entity.UserEventEntity;
import org.springframework.beans.BeanUtils;

public class UserEventMapper {

    public static UserEventResponseDto map(UserEventEntity userEventEntity) {
        UserEventResponseDto eventDto = new UserEventResponseDto();
        BeanUtils.copyProperties(userEventEntity, eventDto);
        String createdDateTime = null != userEventEntity.getCreatedDateTime()
                ? userEventEntity.getCreatedDateTime().toString() : null;
        eventDto.setCreateDateTime(createdDateTime);
        return eventDto;
    }
}
