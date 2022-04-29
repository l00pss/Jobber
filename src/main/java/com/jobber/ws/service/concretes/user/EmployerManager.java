package com.jobber.ws.service.concretes.user;

import com.jobber.ws.service.abstracts.user.EmployerService;
import com.jobber.ws.dataAccess.user.admin.EmployerRepository;
import com.jobber.ws.model.dto.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployerManager implements EmployerService {
    private final EmployerRepository employerRepository;

    @Override
    public UserContext load(String email) {
        return null;
    }


}
