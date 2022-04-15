package com.jobber.vacancy.side.response.factory;


import com.jobber.vacancy.side.response.error.ErrorDataResponse;
import com.jobber.vacancy.side.response.error.ErrorResponse;
import com.jobber.vacancy.side.response.success.SuccessDataResponse;
import com.jobber.vacancy.side.response.success.SuccessResponse;

/**
 * @author vugarmammadli
 */
public abstract class AbstractResponseFactory<T> {

    public abstract SuccessResponse factorySuccessResult(String message);

    public abstract SuccessDataResponse<T> factorySuccessDataResult(T data, String message);

    public abstract SuccessDataResponse<T> factorySuccessDataResult(T data);


    public abstract ErrorResponse factoryErrorResult(String message);

    public abstract ErrorDataResponse<T> factoryErrorDataResult(String message);

    public abstract ErrorDataResponse<T> factoryErrorDataResult(T data, String message);

}