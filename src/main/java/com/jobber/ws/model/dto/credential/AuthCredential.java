package com.jobber.ws.model.dto.credential;

import com.jobber.ws.util.exception.core.BaseException;
import com.jobber.ws.util.exception.business.InvalidLengthException;
import com.jobber.ws.util.exception.business.NullValueException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public final class AuthCredential {
    private String username;
    private String password;

    @PostConstruct
    public void valid() throws BaseException {
        if(username == null || password == null) throw new NullValueException();
        if(username.length()<3 || password.length()<3) throw new InvalidLengthException();
    }

}
