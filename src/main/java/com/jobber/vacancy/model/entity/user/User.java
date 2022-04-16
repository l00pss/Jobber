package com.jobber.vacancy.model.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobber.vacancy.model.entity.contact.Contact;
import com.jobber.vacancy.model.sys.SessionKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@MappedSuperclass
@Getter @AllArgsConstructor @NoArgsConstructor
public class User {
    @SequenceGenerator(name = "USER_GEN_SEQ",
            sequenceName = "USER_SEQ",
            allocationSize = 100,
            initialValue = 3
    )

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "USER_GEN_SEQ")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USER_NAME",unique = true)
    private String username;

    @Column(name = "PASSWORD")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
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

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate = new Date();

    @Column(name = "MODIFICATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private SessionKey key;

    @Column(name = "IS_DELETED_ACCOUNT")
    @JsonIgnore
    private boolean isDeletedAccount = false;

}
