package com.jobber.ws.config.security.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtTokenManager {

    //@Value("${jwt.token.secret}")
    private String secret = "KEY";

    //@Value("${jwt.token.expiration.duration}")
    private long expirationDurationInMs = 24 * 3600L;

    @Autowired
    private EncryptionManager encryptionManager;


    public String generateToken(UserDetails userDetails, String userId) {

        Map<String, Object> claims = new HashMap<>();

        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

        if (roles.contains(new SimpleGrantedAuthority("EMPLOYER"))) {
            claims.put("isEmployer", true);
        }

        if (roles.contains(new SimpleGrantedAuthority("WORKER"))) {
            claims.put("isWorker", true);
        }

        if (userId != null) {
            claims.put("ticket", encryptionManager.encrypt(String.valueOf(userId)));
        }

        return doGenerateToken(claims, userDetails.getUsername());
    }

    public boolean validate(String authToken) {

        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        }
        catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
        }
        catch (ExpiredJwtException ex) {
            throw ex;
        }
    }

    public String getUsernameFromToken(String token) {

        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public List<SimpleGrantedAuthority> getRolesFromToken(String token) {

        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>(2);

        Boolean admin = claims.get("isEmployer", Boolean.class);
        if (admin != null && admin) {
            roles.add(new SimpleGrantedAuthority("EMPLOYER"));
        }

        Boolean user = claims.get("isWorker", Boolean.class);
        if (user != null && user) {
            roles.add(new SimpleGrantedAuthority("WORKER"));
        }
        return roles;
    }

    public String extractTicket(String token) {

        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.get("ticket", String.class);
    }

    public String extractJwtFromRequest(HttpServletRequest request) {
        String data = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(data) && data.startsWith("Bearer ")) {
            return data.substring(7, data.length());
        }
        return null;
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + expirationDurationInMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }
}
