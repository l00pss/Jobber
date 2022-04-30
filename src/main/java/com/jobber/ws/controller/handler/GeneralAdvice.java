package com.jobber.ws.controller.handler;

import com.jobber.ws.util.exception.ExceptionProvider;
import com.jobber.ws.util.exception.core.UnknownException;
import com.jobber.ws.util.response.error.ErrorResponse;
import com.jobber.ws.util.response.factory.AbstractResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
@RequiredArgsConstructor
public class GeneralAdvice {

    private final AbstractResponseFactory<ErrorResponse> responseFactory;
    private final ExceptionProvider exceptionProvider;

    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorResponse handlerException(UnknownException exception) throws IOException {
        this.exceptionProvider.saveException(exception);
        return responseFactory.factoryErrorResult(exception.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handlerException(AccessDeniedException exception) throws IOException {
        this.exceptionProvider.saveException(exception);
        return responseFactory.factoryErrorResult(exception.getMessage());
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerException(UsernameNotFoundException exception) throws IOException {
        this.exceptionProvider.saveException(exception);
        return responseFactory.factoryErrorResult("Istifadəçi tapılmadı");
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerException(Exception exception) throws IOException {
        this.exceptionProvider.saveException(exception);
        return responseFactory.factoryErrorResult(exception.getMessage());
    }
}
