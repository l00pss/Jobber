package com.jobber.ws.util.exception;

import com.jobber.ws.util.exception.core.BaseException;

@JException
public class InvalidRequestException extends BaseException {
    public InvalidRequestException(){
        super();
    }

    public InvalidRequestException(String message){
        super("Düzgün edilməyən istək forması");
    }

    public InvalidRequestException(String message,String reporter){
        super(message,reporter);
    }

    public InvalidRequestException(String message,String reporter,String ext){
        super(message,reporter,ext);
    }
}
