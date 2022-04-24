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
import org.hibernate.annotations.GenericGenerator;
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
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @AllArgsConstructor @NoArgsConstructor @Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class User implements FunctionVisibility  , UserDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    //TODO Bu bir obyekt halina salinmalidir
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

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
