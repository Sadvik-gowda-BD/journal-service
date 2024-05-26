package com.example.journalservice.repository;

import com.example.journalservice.entity.UserCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepo extends JpaRepository<UserCredentialEntity, Long> {
}
