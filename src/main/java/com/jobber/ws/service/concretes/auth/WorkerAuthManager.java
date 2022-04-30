package com.jobber.ws.service.concretes.auth;

import com.jobber.ws.model.dto.credential.RegisterCredential;
import com.jobber.ws.service.AuthenticationService;
import com.jobber.ws.service.abstracts.auth.AuthService;
import com.jobber.ws.service.qualifier.WorkerAuthManagerQualifier;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.Response;
import com.jobber.ws.util.response.success.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@WorkerAuthManagerQualifier
@RequiredArgsConstructor
public class WorkerAuthManager implements AuthService {
    private final AuthenticationService authenticationService;

    @Override
    public Response register(RegisterCredential registerCredential) {
        return null;
    }

    @Override
    public DataResponse<AuthenticationResponse> login(final String authorization) {
        return null;
    }

    @Override
    public Response logout() {
        return null;
    }

    @Override
    public Response forgotPassword(String email) {
        return null;
    }

    @Override
    public DataResponse<String> support() {
        return null;
    }
}
