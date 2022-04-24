package com.jobber.ws.business;

import com.jobber.ws.business.abstracts.user.EmployerService;
import com.jobber.ws.config.security.jwt.JwtTokenManager;
import com.jobber.ws.model.dto.UserContext;
import com.jobber.ws.model.entity.user.User;
import com.jobber.ws.util.response.success.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private EmployerService userService;
    private AuthenticationManager authenticationManager;
    private JwtTokenManager tokenManager;


    public AuthenticationResponse authenticate(String authorization) {

        if(!StringUtils.hasText(authorization)) {
            throw new RuntimeException("INVALID AUTH PAYLOAD");
        }

        String[] httpBasicAuthPayload = parseHttpBasicPayload(authorization);
        String email = httpBasicAuthPayload[0];
        String password = httpBasicAuthPayload[1];

        Authentication authenticate = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(email, password)
                );

        User user = (User) authenticate.getPrincipal();
        if(user == null) {
            throw new RuntimeException("USER NOT FOUND");
        }

        UserContext userContext = userService.load(email);
        String jwtToken = tokenManager.generateToken(user, userContext.getId());
        return new AuthenticationResponse(userContext.getId(), jwtToken);
    }

    private String[] parseHttpBasicPayload(String authorization) {

        if (authorization != null && authorization.toLowerCase().startsWith("basic")) {

            String base64Credentials = authorization.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            return credentials.split(":", 2);
        }
        return null;
    }
}