package com.jobber.ws.service.concretes.user;

import com.jobber.ws.service.abstracts.admin.AdminEmployerService;
import com.jobber.ws.dataAccess.user.admin.AdminEmployerRepository;
import com.jobber.ws.model.dto.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminEmployerManager implements AdminEmployerService {
    private final AdminEmployerRepository adminEmployerRepository;

    @Override
    public UserContext load(String email) {
        return null;
    }


}
