package com.jobber.ws.config.security;

import com.jobber.ws.config.security.entypoint.AuthenticationFailureEntryPoint;
import com.jobber.ws.config.security.jwt.JwtAuthorizationFilter;
import com.jobber.ws.config.security.jwt.JwtTokenManager;
import com.jobber.ws.config.security.provider.EmployerAuthenticationProvider;
import com.jobber.ws.config.security.userdetail.AuthenticationUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Profile("default")
@Configuration
@EnableWebSecurity
@Order(1)
@RequiredArgsConstructor
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationFailureEntryPoint failureEntryPoint;

    private final JwtTokenManager tokenManager;

    private final AuthenticationUserDetailsService authenticationUserDetailsService;


    @Override
    public void configure(HttpSecurity http) throws Exception {

        http = http.cors().and().csrf().disable();

        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        http = http
                .exceptionHandling()
                .authenticationEntryPoint(failureEntryPoint)
                .and();

        http.authorizeRequests()
                .antMatchers("/v2/api-docs", "/api-docs",
                        "/configuration/ui", "/configuration/security",
                        "/swagger-ui/**", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**").permitAll()
                .antMatchers(HttpMethod.POST, "/rest/api/v1/login").permitAll()
                .antMatchers(HttpMethod.POST, "/rest/api/v1/user").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), tokenManager));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        EmployerAuthenticationProvider authenticationProvider = new EmployerAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        authenticationProvider.setUserDetailsService(authenticationUserDetailsService);
        auth.authenticationProvider(authenticationProvider);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}