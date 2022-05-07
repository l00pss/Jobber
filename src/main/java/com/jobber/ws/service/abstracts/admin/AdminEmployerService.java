package com.jobber.ws.service.abstracts.admin;

import com.jobber.ws.model.dto.UserContext;

public interface AdminEmployerService {
    UserContext load(String email);
}
