package com.jobber.ws.model.entity.user;

import com.jobber.ws.modul.auditor.audit.concretes.ProfileAuditable;
import com.jobber.ws.model.dto.credential.RegisterCredential;
import com.jobber.ws.model.entity.contact.Contact;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "JUSER_PROFILE")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile extends ProfileAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private JUser jUser;

    @Column(name = "FIRST_NAME",nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME",nullable = false)
    private String lastName;

    @Column(name = "EMAIL_OF_USER",unique = true)
    private String email;

    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(mappedBy = "profile",cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @Column(name = "PROFILE_IMAGE")
    @Lob
    private String profileImage;

    @Column(name = "COVER_IMAGE")
    @Lob
    private String coverImage;

    @OneToOne
    private UserSettings settings;

    @Column(name = "IS_PREMIUM")
    private Boolean isPremiumAccount = false;

    public UserProfile(RegisterCredential registerCredential){
        super();
        this.firstname = registerCredential.getName();
        this.lastName = registerCredential.getLastName();
        this.email  = registerCredential.getEmail();
    }
}
