package com.jobber.ws.service.abstracts.auth;

import com.jobber.ws.model.dto.credential.RegisterCredential;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.Response;
import com.jobber.ws.util.response.success.AuthenticationResponse;

public interface AuthService {

    Response register(final RegisterCredential registerCredential);

    DataResponse<AuthenticationResponse> login(final String authorization);

    Response logout();

    Response forgotPassword(final String email);

    DataResponse<String> support();
}
