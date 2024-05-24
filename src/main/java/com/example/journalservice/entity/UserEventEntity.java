package com.example.journalservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_EVENT")
public class UserEventEntity {

    @Id
    @GeneratedValue
    @Column(name = "EVENT_ID")
    private long eventId;
    @Column(name = "EVENT_DESCRIPTION")
    private String eventDescription;
    @Column(name = "CREATE_DATE_TIME")
    private LocalDateTime createdDateTime;
}
