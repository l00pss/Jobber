package com.jobber.ws.model.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobber.ws.model.entity.abstracts.FunctionVisibility;
import com.jobber.ws.model.entity.contact.Contact;
import com.jobber.ws.model.entity.other.Visibility;
import com.jobber.ws.model.sys.SessionKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@MappedSuperclass
@Getter @AllArgsConstructor @NoArgsConstructor
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

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "LAST_NAME",nullable = false)
    private String lastName;

    @Column(name = "USER_NAME",unique = true)
    private String username;

    @Column(name = "PASSWORD")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    @JsonIgnore
    private String password;

    @Column(name = "EMAIL_OF_USER",unique = true)
    private String email;

    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(targetEntity = Contact.class)
    private Set<Contact> contacts;

    @Column(name = "PROFILE_IMAGE")@Lob
    private String profileImage;

    @Column(name = "COVER_IMAGE")@Lob
    private String coverImage;

    @Column(name = "IS_PREMIUM")
    private Boolean isPremiumAccount = false;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private SessionKey key;


    //TODO Bu bir obyekt halina salinmalidir
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;
    //TODO ------------------------------------

    @OneToOne
    private Visibility visibility = Visibility.ACTIVE;



    @Override
    public boolean isAppropriate(){
        return this.visibility.isAppropriate();
    }

}
