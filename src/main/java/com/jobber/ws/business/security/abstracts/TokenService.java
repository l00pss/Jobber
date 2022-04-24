package com.jobber.ws.business.security.abstracts;

public interface TokenService {
    String generateToken(String username);

    boolean isValid(String token);

    String getUsername(String token);
}
