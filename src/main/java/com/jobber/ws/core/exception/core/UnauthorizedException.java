package com.jobber.ws.core.exception.core;

import com.jobber.ws.core.exception.core.BaseException;

public class UnauthorizedException extends BaseException {
    public UnauthorizedException(){
        super();
    }

    public UnauthorizedException(String message){
        super(message);
    }

    public UnauthorizedException(String message,String reporter){
        super(message,reporter);
    }

    public UnauthorizedException(String message,String reporter,String extension){
        super(message,reporter,extension);
    }
}
