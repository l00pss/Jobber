package com.jobber.ws.util.exception.core;

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
