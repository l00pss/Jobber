package com.jobber.ws.util.exception.business;

import com.jobber.ws.util.exception.core.BaseException;
import com.jobber.ws.util.exception.JException;

@JException
public class NullValueException extends BaseException {
    public NullValueException(){
        super("Boş dəyər keçilə bilməz. Zəhmət olmasa xanaları doldurun");
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
