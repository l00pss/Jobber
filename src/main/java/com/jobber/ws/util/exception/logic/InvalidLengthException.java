package com.jobber.ws.util.exception.logic;

import com.jobber.ws.util.exception.core.BaseException;

public class InvalidLengthException extends BaseException {
    public InvalidLengthException(){
        super("Səhv uzunluqda parametr aşkarlandı");
    }

    public InvalidLengthException(String message){
        super(message);
    }

    public InvalidLengthException(String message,String reporter){
        super(message,reporter);
    }

    public InvalidLengthException(String message,String reporter,String ext){
        super(message,reporter,ext);
    }

}
