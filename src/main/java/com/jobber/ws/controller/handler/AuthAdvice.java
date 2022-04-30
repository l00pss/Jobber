package com.jobber.ws.controller.handler;


import com.jobber.ws.util.exception.ExceptionProvider;
import com.jobber.ws.util.exception.core.UnknownException;
import com.jobber.ws.util.response.error.ErrorResponse;
import com.jobber.ws.util.response.factory.AbstractResponseFactory;
import com.jobber.ws.util.response.message.MessageProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
@RequiredArgsConstructor
public class AuthAdvice {
    private final AbstractResponseFactory<ErrorResponse> responseFactory;
    private final ExceptionProvider exceptionProvider;
    private final MessageProvider messageProvider;

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handlerException(BadCredentialsException exception) throws IOException {
        this.exceptionProvider.saveException(exception);
        return responseFactory.factoryErrorResult(exception.getMessage());
    }
}
