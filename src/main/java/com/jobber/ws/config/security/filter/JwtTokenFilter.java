package com.jobber.ws.config.security.filter;

import com.jobber.ws.business.security.abstracts.TokenService;
import com.jobber.ws.util.exception.core.BaseException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {


    private TokenService tokenService;

    @SneakyThrows(BaseException.class)
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String username = null;
        String token = request.getHeader("Authorization");
        try {
            if (token!= null && token.contains("Bearer")){
                token = token.substring(7,token.length()-1);
                if (tokenService.validate(token)){
                    username = tokenService.getUsername(token);
                }
            }
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                if(tokenService.validate(token)){
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(username,null);
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
            filterChain.doFilter(request,response);
        }catch (Exception e){
            throw new BaseException(e.getMessage());
        }

    }
}
