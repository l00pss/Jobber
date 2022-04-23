package com.jobber.ws.business.security.abstracts;

import com.jobber.ws.util.helper.GenerateService;

public interface TokenService extends GenerateService {
    boolean validate(String token);

    boolean isValidUser(String token);
}
