package com.example.journalservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CREDENTIALS")
public class UserCredentialEntity {

    @Id
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLE")
    private String role;

}
