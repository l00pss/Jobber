package com.jobber.vacancy.side.exception;

import com.jobber.vacancy.controller.handler.VacancyAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BaseException extends Exception{

    private final static Logger logger = LoggerFactory.getLogger(VacancyAdvice.class);

    public BaseException(){
        super(" Bilinməyən xəta.");
        logger.error(" Bilinməyən xəta. : " + Arrays.toString(this.getStackTrace()));
    }

    public BaseException(String message) {
        super(message);
        logger.error(message + " : " + Arrays.toString(this.getStackTrace()));
    }
}
