package com.jobber.ws.core.response.error;

import com.jobber.ws.core.response.Response;
import org.springframework.boot.web.servlet.error.ErrorController;

/**
 * @author vugarmammadli
 */
public final class ErrorResponse extends Response implements ErrorController {
    public ErrorResponse(){
        super(false);
    }

    public ErrorResponse(String message){
        super(false,message);
    }

}