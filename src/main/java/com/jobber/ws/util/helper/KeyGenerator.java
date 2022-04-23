package com.jobber.ws.util.helper;

import org.springframework.stereotype.Component;

@Component
public class KeyGenerator implements GenerateService{
    @Override
    public String generate() {
        return GenerateService.super.generate();
    }
}
