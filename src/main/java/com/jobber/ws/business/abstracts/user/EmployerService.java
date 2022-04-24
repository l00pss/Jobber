package com.jobber.ws.business.abstracts.user;

import com.jobber.ws.model.dto.UserContext;

public interface EmployerService {
    UserContext load(String email);
}
