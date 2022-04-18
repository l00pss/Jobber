package com.jobber.ws.core.response.error;


import com.jobber.ws.core.response.DataResponse;

/**
 * @author vugarmammadli
 */
public  final class ErrorDataResponse<T> extends DataResponse<T> {
    public ErrorDataResponse(T data, String message) {
        super(data, false, message);
    }

    public ErrorDataResponse(T data, String message, Exception exception) {
        super(data, false, message);
    }

    public ErrorDataResponse(T data){
        super(false,data);
    }

    public ErrorDataResponse(String message){
        super(null,false,message);
    }

    public ErrorDataResponse(){
        super(false,null);
    }
}