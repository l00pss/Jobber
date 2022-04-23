package com.jobber.ws.business.abstracts.auth;

import com.jobber.ws.dataAccess.user.admin.WorkerRepository;
import com.jobber.ws.model.entity.user.User;
import com.jobber.ws.util.exception.core.BaseException;
import com.jobber.ws.util.exception.logic.BlockedAccountException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerDetailsService implements UserDetailsService {
    private final WorkerRepository repository;

    @SneakyThrows(BaseException.class)
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);
        if(user.getVisibility().isBlocked()) throw new BlockedAccountException();
        return user;
    }
}
