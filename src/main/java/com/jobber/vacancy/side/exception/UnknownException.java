package com.jobber.vacancy.side.exception;

import com.jobber.vacancy.controller.handler.VacancyAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnknownException extends BaseException{

    public UnknownException(String message){
        super(message);
    }

    public UnknownException(){
        super();
    }
}
