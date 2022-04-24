package com.jobber.ws.controller.auth;

import com.jobber.ws.business.security.abstracts.TokenService;
import com.jobber.ws.model.dto.request.AuthCredential;
import com.jobber.ws.util.exception.core.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/1.0/auth/employer")
@RequiredArgsConstructor
public class EmployerAuthController {
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthCredential authCredential){

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
