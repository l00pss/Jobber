package com.jobber.ws.model.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobber.ws.model.entity.abstracts.FunctionVisibility;
import com.jobber.ws.model.entity.contact.Contact;
import com.jobber.ws.model.entity.other.Visibility;
import com.jobber.ws.model.sys.SessionKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@MappedSuperclass
@Getter @AllArgsConstructor @NoArgsConstructor @Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class User implements FunctionVisibility  , UserDetails {
    @SequenceGenerator(name = "USER_GEN_SEQ",
            sequenceName = "USER_SEQ",
            allocationSize = 100,
            initialValue = 3
    )

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "USER_GEN_SEQ")
    private Long id;

    //TODO Bu bir obyekt halina salinmalidir
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;
    //TODO ------------------------------------

    @OneToOne
    private Profile profile;

    @Column(name = "USER_NAME",unique = true)
    private String username;

    @OneToOne
    private Password password;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private Set<SessionKey> sessionKeys ;

    @OneToOne
    private Visibility visibility = Visibility.ACTIVE;


    @Override
    public boolean isAppropriate(){
        return this.visibility.isAppropriate();
    }

    public String getPassword() {
        return password.getPassword();
    }
}
