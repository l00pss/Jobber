package com.jobber.ws.business.security;

import com.jobber.ws.business.security.abstracts.TokenService;
import com.jobber.ws.dataAccess.sys.SessionKeyRepository;
import com.jobber.ws.dataAccess.user.admin.EmployerRepository;
import com.jobber.ws.dataAccess.user.admin.WorkerRepository;
import com.jobber.ws.model.entity.other.Visibility;
import com.jobber.ws.model.entity.user.Employer;
import com.jobber.ws.model.entity.user.User;
import com.jobber.ws.model.entity.user.Worker;
import com.jobber.ws.model.sys.SessionKey;
import com.jobber.ws.util.helper.KeyGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenManager implements TokenService {
    private final static Long EXPIRATION = (60L * 60 * 24);
    private final KeyGenerator keyGenerator;
    private final SessionKeyRepository sessionKeyRepository;
    private final EmployerRepository employerRepository;
    private final WorkerRepository workerRepository;


    // FIXME: 23.04.22 Hal hazırda secret key statik olaraq saxlanılır ancaq dinamik implementasiya yazılmalıdır.
    @Transactional
    String saveSession(String role, String username) throws AccessDeniedException {
       String key =  keyGenerator.generate();
       User user;
       if (role.equals("EMPLOYER")){
           user = employerRepository.findByUsernameAndVisibility(username, Visibility.ACTIVE);
           user.getSessionKeys().add(SessionKey.builder().key(key).build());
           employerRepository.save((Employer) user);
       }else if (role.equals("WORKER")){
           user = workerRepository.findByUsernameAndVisibility(username,Visibility.ACTIVE);
           user.getSessionKeys().add(SessionKey.builder().key(key).build());
           workerRepository.save((Worker) user);
       }else throw new AccessDeniedException(" Daxil olmaq hwququnuz yoxdur");
       return key;
    }

    @Override
    public String generate(String role,String username) throws AccessDeniedException {
        String key = saveSession(role,username);
        // FIXME: 23.05.22
        key = "KEY";
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + TokenManager.EXPIRATION * 1000);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }


    @Override
    public String getUsername(String token) {
        Claims claims = this.getClaims(token);
        return claims.getSubject();
    }

    @Override
    public boolean validate(String token) {
        return (isValidUser(token) && !isExpired(token));
    }

    private Claims getClaims(String token){
        return Jwts.parser()
                .setSigningKey("KEY")
                .parseClaimsJws(token)
                .getBody();
    }


    private boolean isExpired(String token) {
        Claims claims = this.getClaims(token);
        return claims.getExpiration().before(new Date());
    }

    @Override
    public boolean isValidUser(String token) {
        Claims claims = this.getClaims(token);
        return claims.getSubject()!=null;
    }
}
