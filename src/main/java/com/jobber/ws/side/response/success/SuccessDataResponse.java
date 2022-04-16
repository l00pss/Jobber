package com.jobber.ws.side.response.success;


import com.jobber.ws.side.response.DataResponse;

/**
 * @author Vugar Mammadli
 */
public final class SuccessDataResponse<T> extends DataResponse<T> {

    public SuccessDataResponse(T data, String message) {
        super(data, true, message);
    }

    public SuccessDataResponse(T data){
        super(true,data);
    }

    public SuccessDataResponse(String message){
        super(null,true,message);
    }

    public SuccessDataResponse(){
        super(true,null);
    }

}