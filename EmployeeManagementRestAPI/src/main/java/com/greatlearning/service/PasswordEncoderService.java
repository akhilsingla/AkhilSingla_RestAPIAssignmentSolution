package com.greatlearning.service;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface PasswordEncoderService {
    public PasswordEncoder getPasswordEncoder();
}
