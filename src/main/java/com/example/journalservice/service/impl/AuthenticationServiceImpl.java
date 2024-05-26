package com.example.journalservice.service.impl;

import com.example.journalservice.dto.LoginUserDetails;
import com.example.journalservice.entity.UserCredentialEntity;
import com.example.journalservice.repository.UserCredentialRepo;
import com.example.journalservice.service.AuthenticationService;
import exception.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserCredentialRepo userCredentialRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentialEntity credentials = userCredentialRepo.findById(Long.valueOf(username))
                .orElseThrow(() -> new UserNotFound("User not found"));
        return new LoginUserDetails(credentials);
    }

}
