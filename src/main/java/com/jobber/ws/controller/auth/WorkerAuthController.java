package com.jobber.ws.controller.auth;

import com.jobber.ws.model.dto.credential.AuthCredential;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/1.0/auth/worker")
public class WorkerAuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthCredential authCredential){

        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthCredential authCredential){

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
