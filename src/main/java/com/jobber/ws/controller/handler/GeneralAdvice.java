package com.jobber.ws.controller.handler;

import com.jobber.ws.core.exception.ExceptionProvider;
import com.jobber.ws.core.response.error.ErrorResponse;
import com.jobber.ws.core.response.factory.AbstractResponseFactory;
import com.jobber.ws.core.response.message.MessageProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorResponse handlerNullValueException(Exception exception) throws IOException {
        this.exceptionProvider.saveException(exception);
        System.out.println(messageProvider.get());
        return responseFactory.factoryErrorResult(exception.getMessage());
    }

}
