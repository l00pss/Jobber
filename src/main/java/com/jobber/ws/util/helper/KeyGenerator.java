package com.jobber.ws.util.helper;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class KeyGenerator implements GenerateService{
    @Override
    public String generate() {
        return Base64.getEncoder().withoutPadding().encodeToString(GenerateService.super.generate().getBytes());
    }
}
