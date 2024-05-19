package com.example.journalservice.repository;

import com.example.journalservice.entity.UserEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventRepository extends JpaRepository<UserEventEntity, Long> {
}
