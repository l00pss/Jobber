package com.jobber.ws.business.concretes.user;

import com.jobber.ws.business.abstracts.user.EmployerService;
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
