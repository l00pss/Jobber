package com.jobber.ws.model.dto.request;

import com.jobber.ws.util.exception.InvalidRequestException;
import com.jobber.ws.util.exception.core.BaseException;
import com.jobber.ws.util.exception.logic.InvalidLengthException;
import com.jobber.ws.util.exception.logic.NullValueException;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Getter
public final class AuthCredential {
    private String username;
    private String password;

    @PostConstruct
    public void valid() throws BaseException {
        if(username == null || password == null) throw new NullValueException();
        if(username.length()<3 || password.length()<3) throw new InvalidLengthException();
    }

}
