package com.jobber.ws.service.concretes.auth;

import com.jobber.ws.dataAccess.user.admin.AdminEmployerRepository;
import com.jobber.ws.dataAccess.vacancy.PanelVacancyRepository;
import com.jobber.ws.model.dto.credential.RegisterCredential;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.ViewVacancyDTO;
import com.jobber.ws.model.entity.user.Employer;
import com.jobber.ws.model.factory.abstracts.AbstractVacancyFactory;
import com.jobber.ws.service.AuthenticationService;
import com.jobber.ws.service.abstracts.auth.AuthService;
import com.jobber.ws.service.qualifier.EmployerAuthManagerQualifier;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.Response;
import com.jobber.ws.util.response.factory.AbstractResponseFactory;
import com.jobber.ws.util.response.message.MessageProvider;
import com.jobber.ws.util.response.message.ResponseMessage;
import com.jobber.ws.util.response.success.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EmployerAuthManagerQualifier
@RequiredArgsConstructor
public class EmployerAuthManager implements AuthService {
    private final AuthenticationService authenticationService;
    private final AbstractResponseFactory<AuthenticationResponse> responseFactory;
    private final AdminEmployerRepository employerRepository;
    private final MessageProvider messageProvider;

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
