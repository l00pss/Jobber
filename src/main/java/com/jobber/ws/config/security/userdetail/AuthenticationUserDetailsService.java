package com.jobber.ws.config.security.userdetail;

import com.jobber.ws.service.abstracts.admin.AdminEmployerService;
import com.jobber.ws.model.dto.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationUserDetailsService implements UserDetailsService {

    private final AdminEmployerService adminEmployerService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserContext userContext = adminEmployerService.load(email);
        if(userContext == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return User.withUsername(userContext.getEmail())
                .password(userContext.getPassword())
                .authorities("USER")
                .build();
    }
}
