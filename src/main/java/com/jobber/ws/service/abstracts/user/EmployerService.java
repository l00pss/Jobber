package com.jobber.ws.service.abstracts.user;

import com.jobber.ws.model.dto.UserContext;

public interface EmployerService {
    UserContext load(String email);
}
