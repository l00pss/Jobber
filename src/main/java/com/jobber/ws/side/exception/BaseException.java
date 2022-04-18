package com.jobber.ws.side.exception;

import com.jobber.ws.controller.handler.GeneralAdvice;
import com.jobber.ws.dataAccess.sys.ExceptionRepository;
import com.jobber.ws.side.model.ModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Arrays;

@Component
public class BaseException extends Exception {

    @Autowired
    private  ExceptionRepository repository;

    private final static Logger logger = LoggerFactory.getLogger(GeneralAdvice.class);

    public BaseException(){
        super(" Bilinməyən xəta.");
        this.saveException(this);
    }

    public BaseException(String message) {
        super(message);
        this.saveException(this);
    }

    public BaseException(String reporter,String message) {
        this(message);
        this.saveException(this,reporter);
    }

    public BaseException(String reporter,String extension,String message) {
        this(reporter,message);
        this.saveException(this,reporter,extension);
    }

    private void saveException(Exception exception){
        ModelException modelException = ModelException
                .factory(exception.getMessage(),
                        Arrays.toString(exception.getStackTrace()),
                        exception.getLocalizedMessage());
        repository.save(modelException);
    }

    private void saveException(Exception exception,String reporter){
        ModelException modelException = ModelException
                .factory(exception.getMessage(),
                        Arrays.toString(exception.getStackTrace()),
                        exception.getLocalizedMessage(),
                        reporter);
        repository.save(modelException);
    }

    private void saveException(Exception exception,String reporter,String extension){
        ModelException modelException = ModelException
                .factory(exception.getMessage(),
                        Arrays.toString(exception.getStackTrace()),
                        exception.getLocalizedMessage(),
                        reporter);
        repository.save(modelException);
    }
}
