package com.jobber.ws.config.security.jwt;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

@Component
public class EncryptionManager {

    private final String salt = "DEVTECH-SECRET*!>>";

    public String encrypt(String payload) {

        if(!StringUtils.hasText(payload)) {
            return "";
        }
        return DigestUtils.md5DigestAsHex((payload + salt).getBytes(StandardCharsets.UTF_8));
    }
}