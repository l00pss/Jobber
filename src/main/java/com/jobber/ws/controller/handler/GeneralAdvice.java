package com.jobber.ws.controller.handler;

import com.jobber.ws.core.exception.ExceptionProvider;
import com.jobber.ws.core.exception.core.UnknownException;
import com.jobber.ws.core.response.error.ErrorResponse;
import com.jobber.ws.core.response.factory.AbstractResponseFactory;
import com.jobber.ws.core.response.message.MessageProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
@RequiredArgsConstructor
public class GeneralAdvice {

    private final AbstractResponseFactory<ErrorResponse> responseFactory;
    private final ExceptionProvider exceptionProvider;
    private final MessageProvider messageProvider;

    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorResponse handlerNullValueException(UnknownException exception) throws IOException {
        this.exceptionProvider.saveException(exception);
        return responseFactory.factoryErrorResult(exception.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handlerNullValueException(AccessDeniedException exception) throws IOException {
        this.exceptionProvider.saveException(exception);
        return responseFactory.factoryErrorResult(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerNullValueException(Exception exception) throws IOException {
        this.exceptionProvider.saveException(exception);
        return responseFactory.factoryErrorResult(exception.getMessage());
    }

}
