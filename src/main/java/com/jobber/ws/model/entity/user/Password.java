package com.jobber.ws.model.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PASSWORD_PROVIDER")
@RequiredArgsConstructor @Data
public final class Password {

//    @Transient
//    private PasswordEncoder passwordEncoder;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @LastModifiedDate
    @Column(name = "MODIFICATION_DATE")
    private Date modificationDate;

    @Column(name = "PASSWORD",nullable = false)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    @JsonIgnore
    private String password;

    public boolean matches(final String raw){
        return false;//this.passwordEncoder.matches(raw,this.password);
    }

    public Password(String password){
        this.password = password.trim();
    }
}
