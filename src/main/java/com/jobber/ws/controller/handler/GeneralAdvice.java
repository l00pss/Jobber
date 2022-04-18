package com.jobber.ws.controller.handler;

import com.jobber.ws.core.exception.UnknownException;
import com.jobber.ws.core.response.error.ErrorResponse;
import com.jobber.ws.core.response.factory.AbstractResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GeneralAdvice {

    private final AbstractResponseFactory<ErrorResponse> responseFactory;

    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorResponse handlerNullValueException(UnknownException exception){
        return responseFactory.factoryErrorResult(exception.getMessage());
    }
}
