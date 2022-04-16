package com.jobber.vacancy.side.exception;

public class UnknownException extends BaseException{

    public UnknownException(String message){
        super(message);
    }

    public UnknownException(){
        super();
    }
}
