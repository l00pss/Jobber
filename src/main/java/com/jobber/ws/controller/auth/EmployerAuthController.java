package com.jobber.ws.controller.auth;

import com.jobber.ws.service.AuthenticationService;
import com.jobber.ws.model.dto.credential.AuthCredential;
import com.jobber.ws.model.dto.credential.RegisterCredential;
import com.jobber.ws.util.response.success.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/1.0/auth/employer")
@RequiredArgsConstructor
public class EmployerAuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
        try {

            AuthenticationResponse response = authenticationService.authenticate(authorization);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, response.getToken())
                    .body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterCredential registerCredential){

        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody AuthCredential authCredential){

        return null;
    }

    @PostMapping("/forgot")
    public ResponseEntity<String> forgotPassword(@RequestParam String email){

        return null;
    }
}
