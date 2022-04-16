package com.jobber.vacancy.controller.handler;

import com.jobber.vacancy.side.exception.UnknownException;
import com.jobber.vacancy.side.response.error.ErrorResponse;
import com.jobber.vacancy.side.response.factory.AbstractResponseFactory;
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
