package com.jobber.ws.business.security.concretes;

import com.jobber.ws.business.security.abstracts.TokenService;
import com.jobber.ws.util.helper.JEncoder;
import com.jobber.ws.util.helper.KeyGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenManager implements TokenService {
    private final KeyGenerator keyGenerator;
    private final JEncoder jEncoder;

    private static final Long EXPIRED_TIME = 24L * 3600000;

    private final String secretKey = this.jEncoder.encode("EXAMPLE_KEY");

    @Override
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("www.jobber.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TokenManager.EXPIRED_TIME))
                .signWith(SignatureAlgorithm.HS512,this.secretKey)
                .compact();
    }

    @Override
    public boolean isValid(String token) {
        return getUsername(token) != null && isExpired(token);
    }

    private boolean isExpired(String token){
        return this.getClaims(token).getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
    }

    @Override
    public String getUsername(String token){
        return this.getClaims(token).getSubject();
    }

}
