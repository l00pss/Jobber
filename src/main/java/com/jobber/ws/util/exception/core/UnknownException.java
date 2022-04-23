package com.jobber.ws.util.exception.core;

public class UnknownException extends BaseException {

    public UnknownException(){
        super();
    }

    public UnknownException(String message){
        super(message);
    }

    public UnknownException(String message,String reporter){
        super(message,reporter);
    }

    public UnknownException(String message,String reporter,String extension){
        super(message,reporter,extension);
    }

}
