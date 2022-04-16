package com.jobber.ws.side.exception;

public class UnknownException extends BaseException{

    public UnknownException(String message){
        super(message);
    }

    public UnknownException(){
        super();
    }
}
