package com.jobber.ws.core.exception.logic;

import com.jobber.ws.core.exception.BaseException;

public class UserNotFoundException extends BaseException{

    public UserNotFoundException(){
        super();
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