package com.jobber.ws.util.response.factory;

import com.jobber.ws.util.response.error.ErrorDataResponse;
import com.jobber.ws.util.response.error.ErrorResponse;
import com.jobber.ws.util.response.success.SuccessDataResponse;
import com.jobber.ws.util.response.success.SuccessResponse;
import org.springframework.stereotype.Component;

/**
 * @author vugarmammadli
 */
@Component
public class ResponseFactory<T> extends AbstractResponseFactory<T> {

    @Override
    public SuccessResponse factorySuccessResult(String message) {
        return new SuccessResponse(message);
    }

    @Override
    public ErrorResponse factoryErrorResult(String message) {
        return new ErrorResponse(message);
    }

    @Override
    public SuccessDataResponse<T> factorySuccessDataResult(T data, String message) {
        return new SuccessDataResponse<T>(data,message);
    }

    @Override
    public SuccessDataResponse<T> factorySuccessDataResult(T data) {
        return new SuccessDataResponse<T>(data);
    }

    @Override
    public ErrorDataResponse<T> factoryErrorDataResult(String message) {
        return new ErrorDataResponse<T>(message);
    }

    @Override
    public ErrorDataResponse<T> factoryErrorDataResult(T data, String message) {
        return new ErrorDataResponse<T>(data,message);
    }


}