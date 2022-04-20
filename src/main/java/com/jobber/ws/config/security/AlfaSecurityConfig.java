package com.jobber.ws.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Profile("default")
@EnableWebSecurity
@RequiredArgsConstructor
public class AlfaSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final String[] empAccess =
            {"/api/1.0/panel/employer/**"};

    private final String[] wrkAccess =
            {"/api/1.0/panel/worker/**"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/1.0/common/**")
                .permitAll()
                .antMatchers(empAccess)
                .hasRole("EMPLOYER")
                .antMatchers(wrkAccess)
                .hasRole("WORKER")
                .antMatchers("/api/1.0/jobber")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("EX_WORKER")
                .password(passwordEncoder.encode("12345"))
                .roles("WORKER")
                .and()
                .withUser("EX_EMPLOYER")
                .password(passwordEncoder.encode("12345"))
                .roles("EMPLOYER")
                .and()
                .withUser("ADMIN")
                .password(passwordEncoder.encode("12345"))
                .roles("ADMIN");
    }


}
