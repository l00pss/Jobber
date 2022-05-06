package com.jobber.ws.model.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobber.ws.config.audit.UserAuditor;
import com.jobber.ws.model.dto.credential.RegisterCredential;
import com.jobber.ws.model.entity.abstracts.FunctionVisibility;
import com.jobber.ws.model.entity.other.Visibility;
import com.jobber.ws.model.sys.SessionKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @AllArgsConstructor @NoArgsConstructor @Setter
@EntityListeners(UserAuditor.class)
public class JUser implements FunctionVisibility  , UserDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @CreatedDate
    private long createdDate;

    @LastModifiedDate
    private long modifiedDate;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "jUser")
    private UserProfile userProfile;

    @Column(name = "JUSER_NAME",unique = true)
    private String username;

    @OneToOne(mappedBy = "jUser", cascade = CascadeType.ALL)
    private Password password;

    @JsonIgnore
    @OneToMany(mappedBy = "jUser")
    private Set<SessionKey> sessionKeys ;

    @OneToOne(targetEntity = Visibility.class,
    cascade = CascadeType.ALL)
    private Visibility visibility;

    @OneToOne
    private UserSettings userSettings;

    @Override
    public boolean isAppropriate(){
        return this.visibility.isAppropriate();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


    public JUser(RegisterCredential registerCredential){
        this.userProfile = new UserProfile(registerCredential);
        this.userProfile.setJUser(this);
        this.visibility = Visibility.ACTIVE;
    }
}
