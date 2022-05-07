package com.jobber.ws.util.exception.business;

import com.jobber.ws.util.exception.core.BaseException;
import com.jobber.ws.util.exception.JException;

@JException
public class UserNotFoundException extends BaseException{

    public UserNotFoundException(){
        super("Istifadəçi tapılmadı");
    }

    public UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(String message,String reporter){
        super(message,reporter);
    }

    public UserNotFoundException(String message,String reporter,String ext){
        super(message,reporter,ext);
    }

}