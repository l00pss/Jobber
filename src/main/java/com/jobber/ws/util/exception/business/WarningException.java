package com.jobber.ws.util.exception.business;

import com.jobber.ws.util.exception.JException;
import com.jobber.ws.util.exception.core.BaseException;

@JException
public class WarningException extends BaseException {

    public WarningException(String message){
        super(message);
    }

    public WarningException(String message,String reporter){
        super(message,reporter);
    }

    public WarningException(String message,String reporter,String ext){
        super(message,reporter,ext);
    }
}
