package com.jobber.ws.core.exception.logic;

import com.jobber.ws.core.exception.core.BaseException;
import com.jobber.ws.core.exception.JException;

@JException
public class NullValueException extends BaseException {
    public NullValueException(){
        super();
    }

    public NullValueException(String message){
        super(message);
    }

    public NullValueException(String message,String reporter){
        super(message,reporter);
    }

    public NullValueException(String message,String reporter,String ext){
        super(message,reporter,ext);
    }
}
