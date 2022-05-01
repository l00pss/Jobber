package com.jobber.ws.controller.auth;

import com.jobber.ws.service.AuthenticationService;
import com.jobber.ws.model.dto.credential.AuthCredential;
import com.jobber.ws.model.dto.credential.RegisterCredential;
import com.jobber.ws.service.abstracts.auth.AuthService;
import com.jobber.ws.service.qualifier.EmployerAuthManagerQualifier;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.Response;
import com.jobber.ws.util.response.success.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/1.0/auth/employer")
public class EmployerAuthController {

    private final AuthService authService;
    private final AuthenticationService authenticationService;

    @Autowired
    public EmployerAuthController(@EmployerAuthManagerQualifier  AuthService authService,
                                  AuthenticationService authenticationService)
    {
        this.authService = authService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
        DataResponse<AuthenticationResponse> response =  this.authService.login(authorization);
        return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, response.getData().getToken())
                    .body(response.getData());
    }

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody RegisterCredential registerCredential){
        return new ResponseEntity<>(authService.register(registerCredential), HttpStatus.CREATED);
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody AuthCredential authCredential){

        return null;
    }

    @PostMapping("/forgot")
    public ResponseEntity<String> forgotPassword(@RequestParam String email){

        return null;
    }

    @GetMapping("/forgot/support")
    public ResponseEntity<String> support(){
        return null;
    }
}

