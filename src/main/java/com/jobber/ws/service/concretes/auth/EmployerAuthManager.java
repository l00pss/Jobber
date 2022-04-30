package com.jobber.ws.service.concretes.auth;

import com.jobber.ws.dataAccess.user.admin.AdminEmployerRepository;
import com.jobber.ws.model.dto.credential.RegisterCredential;
import com.jobber.ws.model.entity.user.Employer;
import com.jobber.ws.service.AuthenticationService;
import com.jobber.ws.service.abstracts.auth.AuthService;
import com.jobber.ws.service.qualifier.EmployerAuthManagerQualifier;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.Response;
import com.jobber.ws.util.response.factory.AbstractResponseFactory;
import com.jobber.ws.util.response.message.ResponseMessage;
import com.jobber.ws.util.response.success.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;


@Service
@EmployerAuthManagerQualifier
@RequiredArgsConstructor
public class EmployerAuthManager implements AuthService {
    private final AuthenticationService authenticationService;
    private final AbstractResponseFactory<AuthenticationResponse> responseFactory;
    private final AdminEmployerRepository employerRepository;


    @Override
    public Response register(final RegisterCredential registerCredential) {
        employerRepository.save(new Employer(registerCredential));
        return responseFactory.factorySuccessResult(ResponseMessage.CLIENT_ERROR.get("001"));
    }

    @Override
    @SneakyThrows(BadCredentialsException.class)
    public DataResponse<AuthenticationResponse> login(final String authorization) {
        return responseFactory.factorySuccessDataResult(authenticationService.authenticate(authorization));
    }

    @Override
    public Response logout() {
        return null;
    }

    @Override
    public Response forgotPassword(final String email) {
        return null;
    }

    @Override
    public DataResponse<String> support() {
        return null;
    }
}
