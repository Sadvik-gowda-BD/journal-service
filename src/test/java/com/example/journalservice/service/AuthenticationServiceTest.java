package com.example.journalservice.service;

import com.example.journalservice.entity.RoleEntity;
import com.example.journalservice.entity.UserCredentialEntity;
import com.example.journalservice.exception.UserNotFound;
import com.example.journalservice.repository.UserCredentialRepo;
import com.example.journalservice.service.impl.AuthenticationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

import static com.example.journalservice.utils.Constant.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {

    @InjectMocks
    AuthenticationServiceImpl authenticationService;
    @Mock
    UserCredentialRepo userCredentialRepo;

    @Test
    void loadUserByUsernameTest() {
        RoleEntity userRole = RoleEntity.builder()
                .role(ROLE_USER)
                .build();
        UserCredentialEntity userCredential = UserCredentialEntity.builder()
                .userId(USER_ID_1)
                .role(userRole)
                .password(PASSWORD)
                .build();

        when(userCredentialRepo.findById(USER_ID_1)).thenReturn(Optional.of(userCredential));

        UserDetails response = authenticationService.loadUserByUsername(String.valueOf(USER_ID_1));

        assertNotNull(response);
        assertEquals(String.valueOf(USER_ID_1), response.getUsername());
        assertEquals(PASSWORD, response.getPassword());
        List<? extends GrantedAuthority> grantedAuthorities = response.getAuthorities().stream().toList();
        GrantedAuthority grantedAuthority = grantedAuthorities.get(0);
        assertEquals(ROLE_USER, grantedAuthority.getAuthority());
    }

    @Test
    void loadUByNameTestWhenUserNotFound() {
        when(userCredentialRepo.findById(USER_ID_1)).thenReturn(Optional.empty());
        UserNotFound exception = assertThrows(UserNotFound.class, () -> authenticationService.
                loadUserByUsername(String.valueOf(USER_ID_1)));
        assertEquals(USER_NOT_FOUND_EX_MESSAGE, exception.getMessage());
    }

}
